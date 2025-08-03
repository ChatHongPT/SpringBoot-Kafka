package com.fisa.kafrika_backend.service;

import static com.fisa.kafrika_backend.common.config.ChatSetInitializer.DEFAULT_CHATROOM;
import static com.fisa.kafrika_backend.common.response.status.BaseExceptionResponseStatus.CHATROOM_NOT_FOUND;
import static com.fisa.kafrika_backend.common.response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;
import static com.fisa.kafrika_backend.service.ChatKafkaListener.KAFKA_TOPIC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fisa.kafrika_backend.common.exception.CustomException;
import com.fisa.kafrika_backend.dto.ChatMessageRequest;
import com.fisa.kafrika_backend.dto.ChatMessageResponse;
import com.fisa.kafrika_backend.entity.ChatMessage;
import com.fisa.kafrika_backend.entity.ChatRoom;
import com.fisa.kafrika_backend.entity.User;
import com.fisa.kafrika_backend.repository.ChatRoomRepository;
import com.fisa.kafrika_backend.repository.ChattingRepository;
import com.fisa.kafrika_backend.repository.UserRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChattingRepository chattingRepository;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Transactional(readOnly = true)
    public ArrayList<ChatMessageResponse> readChatMessageLog() {
        ChatRoom chatRoom = chatRoomRepository.findByName(DEFAULT_CHATROOM)
                .orElseThrow(() -> new CustomException(CHATROOM_NOT_FOUND));

        return chattingRepository.findByChatRoom(chatRoom).stream()
                .map(chatMessage -> ChatMessageResponse.builder()
                        .id(chatMessage.getId())
                        .senderId(chatMessage.getUser().getId())
                        .senderName(chatMessage.getUser().getName())
                        .message(chatMessage.getDetailMessage())
                        .sendAt(chatMessage.getCreatedAt())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Transactional
    public ChatMessageResponse sendChatMessage(ChatMessageRequest chatMessageRequest) {
        ChatRoom chatRoom = chatRoomRepository.findByName(DEFAULT_CHATROOM)
                .orElseThrow(() -> new CustomException(CHATROOM_NOT_FOUND));

        Long userId = extractUserIdFromString(chatMessageRequest.getUserId());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        ChatMessage saved = chattingRepository.save(
                ChatMessage.builder()
                        .chatRoom(chatRoom)
                        .user(user)
                        .detailMessage(chatMessageRequest.getMessage())
                        .build()
        );

        return ChatMessageResponse.builder()
                .id(saved.getId())
                .senderId(user.getId())
                .senderName(user.getName())
                .message(saved.getDetailMessage())
                .sendAt(saved.getCreatedAt())
                .build();
    }

    public void sendKafkaChatMessage(ChatMessageRequest chatMessageRequest) {
        try {
            String message = objectMapper.writeValueAsString(chatMessageRequest);
            System.out.println("직렬화 완료");
            kafkaTemplate.send(KAFKA_TOPIC, chatMessageRequest.getUserId(), message);
        } catch (JsonProcessingException e) {
            // TODO: db에 저장?
            throw new RuntimeException("Kafka 직렬화 실패", e);
        }
    }
    
    /**
     * "user1", "user2" 형태의 문자열에서 숫자만 추출하여 Long으로 변환
     */
    private Long extractUserIdFromString(String userIdStr) {
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }
        
        // "user1" -> "1", "user2" -> "2"
        String numericPart = userIdStr.replaceAll("[^0-9]", "");
        if (numericPart.isEmpty()) {
            throw new IllegalArgumentException("UserId must contain numeric part: " + userIdStr);
        }
        
        return Long.parseLong(numericPart);
    }
}

package com.fisa.kafrika_backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessageRequest {

    private String userId;

    private String message;

    private String sendAt;
}

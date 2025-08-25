# 📋 Kafrika API 명세서

## 📖 개요

Kafrika 실시간 채팅 애플리케이션의 REST API 및 WebSocket API 명세서입니다.

**Base URL**: `http://localhost:8080`  
**WebSocket URL**: `ws://localhost:8080/ws`

## 🔐 인증

### JWT 토큰 인증

대부분의 API는 JWT 토큰 인증이 필요합니다. 헤더에 다음과 같이 포함하세요:

```http
Authorization: Bearer {accessToken}
```

### 토큰 갱신

액세스 토큰이 만료되면 리프레시 토큰을 사용하여 갱신할 수 있습니다:

```http
POST /api/auth/refresh
Content-Type: application/json

{
  "refreshToken": "string"
}
```

## 🔐 인증 API

### 회원가입

새로운 사용자를 등록합니다.

```http
POST /api/auth/signup
Content-Type: application/json
```

**Request Body**

```json
{
  "username": "string",
  "email": "string",
  "password": "string",
  "confirmPassword": "string"
}
```

**Response (200)**

```json
{
  "success": true,
  "message": "회원가입이 완료되었습니다.",
  "data": {
    "userId": "string",
    "username": "string",
    "email": "string",
    "createdAt": "2024-01-01T00:00:00Z"
  }
}
```

**Error Response (400)**

```json
{
  "success": false,
  "message": "이미 존재하는 이메일입니다.",
  "error": "EMAIL_ALREADY_EXISTS"
}
```

### 로그인

사용자 인증을 수행합니다.

```http
POST /api/auth/login
Content-Type: application/json
```

**Request Body**

```json
{
  "email": "string",
  "password": "string"
}
```

**Response (200)**

```json
{
  "success": true,
  "message": "로그인이 완료되었습니다.",
  "data": {
    "accessToken": "string",
    "refreshToken": "string",
    "user": {
      "userId": "string",
      "username": "string",
      "email": "string"
    }
  }
}
```

### 비밀번호 재설정

이메일을 통해 비밀번호 재설정 링크를 전송합니다.

```http
POST /api/auth/reset-password
Content-Type: application/json
```

**Request Body**

```json
{
  "email": "string"
}
```

**Response (200)**

```json
{
  "success": true,
  "message": "비밀번호 재설정 이메일이 전송되었습니다."
}
```

### 로그아웃

사용자 로그아웃을 수행합니다.

```http
POST /api/auth/logout
Authorization: Bearer {accessToken}
```

**Response (200)**

```json
{
  "success": true,
  "message": "로그아웃이 완료되었습니다."
}
```

## 💬 채팅 API

### 채팅 메시지 전송 (일반)

일반적인 채팅 메시지를 전송합니다.

```http
POST /api/chat/send
Authorization: Bearer {accessToken}
Content-Type: application/json
```

**Request Body**

```json
{
  "roomId": "string",
  "message": "string",
  "messageType": "TEXT"
}
```

**Message Types**

- `TEXT`: 일반 텍스트 메시지
- `IMAGE`: 이미지 메시지
- `FILE`: 파일 메시지
- `SYSTEM`: 시스템 메시지

**Response (200)**

```json
{
  "success": true,
  "message": "메시지가 전송되었습니다.",
  "data": {
    "messageId": "string",
    "roomId": "string",
    "senderId": "string",
    "message": "string",
    "messageType": "TEXT",
    "timestamp": "2024-01-01T00:00:00Z"
  }
}
```

### 채팅 메시지 전송 (Kafka)

Kafka를 통한 비동기 메시지 전송을 수행합니다.

```http
POST /api/chat/send-kafka
Authorization: Bearer {accessToken}
Content-Type: application/json
```

**Request Body**

```json
{
  "roomId": "string",
  "message": "string",
  "messageType": "TEXT"
}
```

**Response (200)**

```json
{
  "success": true,
  "message": "메시지가 Kafka로 전송되었습니다.",
  "data": {
    "messageId": "string",
    "kafkaTopic": "chat-message",
    "timestamp": "2024-01-01T00:00:00Z"
  }
}
```

### 채팅 로그 조회

채팅방의 메시지 히스토리를 조회합니다.

```http
GET /api/chat/log?roomId={roomId}&page={page}&size={size}
Authorization: Bearer {accessToken}
```

**Query Parameters**

- `roomId` (required): 채팅방 ID
- `page` (optional): 페이지 번호 (기본값: 0)
- `size` (optional): 페이지 크기 (기본값: 20)

**Response (200)**

```json
{
  "success": true,
  "data": {
    "messages": [
      {
        "messageId": "string",
        "roomId": "string",
        "senderId": "string",
        "senderName": "string",
        "message": "string",
        "messageType": "TEXT",
        "timestamp": "2024-01-01T00:00:00Z"
      }
    ],
    "pagination": {
      "page": 0,
      "size": 20,
      "totalElements": 100,
      "totalPages": 5,
      "hasNext": true,
      "hasPrevious": false
    }
  }
}
```

### 채팅방 생성

새로운 채팅방을 생성합니다.

```http
POST /api/chat/room
Authorization: Bearer {accessToken}
Content-Type: application/json
```

**Request Body**

```json
{
  "roomName": "string",
  "roomType": "PUBLIC",
  "description": "string"
}
```

**Room Types**

- `PUBLIC`: 공개 채팅방
- `PRIVATE`: 비공개 채팅방
- `DIRECT`: 1:1 채팅방

**Response (200)**

```json
{
  "success": true,
  "message": "채팅방이 생성되었습니다.",
  "data": {
    "roomId": "string",
    "roomName": "string",
    "roomType": "PUBLIC",
    "creatorId": "string",
    "createdAt": "2024-01-01T00:00:00Z"
  }
}
```

### 채팅방 목록 조회

사용자가 참여 중인 채팅방 목록을 조회합니다.

```http
GET /api/chat/rooms
Authorization: Bearer {accessToken}
```

**Response (200)**

```json
{
  "success": true,
  "data": {
    "rooms": [
      {
        "roomId": "string",
        "roomName": "string",
        "roomType": "PUBLIC",
        "lastMessage": "string",
        "lastMessageTime": "2024-01-01T00:00:00Z",
        "unreadCount": 5
      }
    ]
  }
}
```

## 👥 사용자 API

### 사용자 정보 조회

현재 로그인한 사용자의 정보를 조회합니다.

```http
GET /api/user/profile
Authorization: Bearer {accessToken}
```

**Response (200)**

```json
{
  "success": true,
  "data": {
    "userId": "string",
    "username": "string",
    "email": "string",
    "createdAt": "2024-01-01T00:00:00Z",
    "lastLoginAt": "2024-01-01T00:00:00Z"
  }
}
```

### 사용자 정보 수정

사용자 정보를 수정합니다.

```http
PUT /api/user/profile
Authorization: Bearer {accessToken}
Content-Type: application/json
```

**Request Body**

```json
{
  "username": "string",
  "email": "string"
}
```

**Response (200)**

```json
{
  "success": true,
  "message": "사용자 정보가 수정되었습니다.",
  "data": {
    "userId": "string",
    "username": "string",
    "email": "string",
    "updatedAt": "2024-01-01T00:00:00Z"
  }
}
```

### 사용자 목록 조회 (관리자)

모든 사용자 목록을 조회합니다. (관리자 권한 필요)

```http
GET /api/user/list?page={page}&size={size}
Authorization: Bearer {accessToken}
```

**Response (200)**

```json
{
  "success": true,
  "data": {
    "users": [
      {
        "userId": "string",
        "username": "string",
        "email": "string",
        "status": "ACTIVE",
        "createdAt": "2024-01-01T00:00:00Z"
      }
    ],
    "pagination": {
      "page": 0,
      "size": 20,
      "totalElements": 100,
      "totalPages": 5
    }
  }
}
```

## 📊 모니터링 API

### 시스템 상태 조회

애플리케이션의 전반적인 상태를 조회합니다.

```http
GET /actuator/health
```

**Response (200)**

```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "PostgreSQL",
        "validationQuery": "isValid()"
      }
    },
    "kafka": {
      "status": "UP",
      "details": {
        "broker": "localhost:9092"
      }
    }
  }
}
```

### 메트릭 조회

시스템 메트릭을 조회합니다.

```http
GET /actuator/metrics
```

**Response (200)**

```json
{
  "names": [
    "jvm.memory.used",
    "http.server.requests",
    "kafka.consumer.records-consumed-total"
  ]
}
```

### 특정 메트릭 조회

특정 메트릭의 상세 정보를 조회합니다.

```http
GET /actuator/metrics/{metricName}
```

**Response (200)**

```json
{
  "name": "http.server.requests",
  "description": "Number of HTTP server requests",
  "baseUnit": "requests",
  "measurements": [
    {
      "statistic": "COUNT",
      "value": 1000
    }
  ]
}
```

## 🔌 WebSocket API

### 연결

WebSocket 연결을 설정합니다.

```javascript
const socket = new WebSocket("ws://localhost:8080/ws");
```

### 메시지 전송

#### 일반 채팅 메시지

```javascript
socket.send(
  JSON.stringify({
    destination: "/pub/chat",
    body: JSON.stringify({
      roomId: "room-123",
      message: "Hello, World!",
      messageType: "TEXT",
    }),
  })
);
```

#### Kafka 채팅 메시지

```javascript
socket.send(
  JSON.stringify({
    destination: "/pub/kafka-chat",
    body: JSON.stringify({
      roomId: "room-123",
      message: "Hello, Kafka!",
      messageType: "TEXT",
    }),
  })
);
```

### 메시지 구독

채팅 메시지를 구독합니다.

```javascript
socket.send(
  JSON.stringify({
    destination: "/topic/chat",
    body: "",
  })
);
```

### 메시지 수신

```javascript
socket.onmessage = function (event) {
  const message = JSON.parse(event.data);
  console.log("Received:", message);
};
```

## 🚨 에러 코드

### HTTP 상태 코드

- `200`: 성공
- `201`: 생성됨
- `400`: 잘못된 요청
- `401`: 인증 실패
- `403`: 권한 없음
- `404`: 리소스를 찾을 수 없음
- `500`: 서버 내부 오류

### 비즈니스 에러 코드

- `EMAIL_ALREADY_EXISTS`: 이미 존재하는 이메일
- `INVALID_CREDENTIALS`: 잘못된 인증 정보
- `TOKEN_EXPIRED`: 토큰 만료
- `ROOM_NOT_FOUND`: 채팅방을 찾을 수 없음
- `USER_NOT_FOUND`: 사용자를 찾을 수 없음
- `INSUFFICIENT_PERMISSIONS`: 권한 부족

## 📝 예제 코드

### JavaScript/TypeScript

```javascript
// API 클라이언트 예제
class KafrikaAPI {
  constructor(baseURL = "http://localhost:8080") {
    this.baseURL = baseURL;
    this.token = null;
  }

  async login(email, password) {
    const response = await fetch(`${this.baseURL}/api/auth/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
    });

    const data = await response.json();
    if (data.success) {
      this.token = data.data.accessToken;
    }
    return data;
  }

  async sendMessage(roomId, message) {
    const response = await fetch(`${this.baseURL}/api/chat/send`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${this.token}`,
      },
      body: JSON.stringify({
        roomId,
        message,
        messageType: "TEXT",
      }),
    });

    return await response.json();
  }
}
```

### cURL 예제

```bash
# 로그인
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'

# 메시지 전송
curl -X POST http://localhost:8080/api/chat/send \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
  -d '{"roomId":"room-123","message":"Hello!","messageType":"TEXT"}'

# 채팅 로그 조회
curl -X GET "http://localhost:8080/api/chat/log?roomId=room-123&page=0&size=20" \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN"
```

---

**API 버전**: v1.0  
**최종 업데이트**: 2024-01-01

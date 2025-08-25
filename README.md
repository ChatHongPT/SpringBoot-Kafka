##🏧 Kubernetes 기반 DevOps 파이프라인으로 구축한 금융권 서비스 장애 대응 시나리오 프로젝트

<img width="500" height="500" alt="won-removebg-preview" src="https://github.com/user-attachments/assets/8291be1b-264b-43bb-a03b-7fffad266033" />

## 🚀 프로젝트 소개

KAFRIKA 팀은 우리페이먼츠와 협업하여 대용량 트래픽을 처리하는 클라우드 기반 시스템을 개발하는 팀입니다. 이 프로젝트는 Spring Boot 백엔드와 React 프론트엔드로 구성된 실시간 채팅 애플리케이션입니다.

## 📁 프로젝트 구조

```
SpringBoot-Kafka/
├── BE/                    # 백엔드 (Spring Boot + Kafka)
│   ├── src/              # Spring Boot 소스 코드
│   ├── build/            # 빌드 결과물
│   ├── jmeter-tests/     # 부하 테스트 스크립트
│   ├── monitoring/       # 모니터링 설정
│   ├── scripts/          # 유틸리티 스크립트
│   ├── build.gradle      # Gradle 설정
│   └── Dockerfile        # 백엔드 Docker 설정
├── FE/                    # 프론트엔드 (React + TypeScript)
│   ├── src/              # React 소스 코드
│   ├── public/           # 정적 파일
│   ├── package.json      # npm 의존성
│   ├── tsconfig.json     # TypeScript 설정
│   ├── Dockerfile        # 프론트엔드 Docker 설정
│   └── nginx.conf        # nginx 설정
├── docker-compose.yml     # 전체 서비스 오케스트레이션
└── README.md             # 프로젝트 문서
```

## ⚙️ 개발 환경 및 기술 스택

<table>
<tr>
 <td align="center">Frontend</td>
 <td>
  <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white"/>&nbsp 
  <img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=TypeScript&logoColor=white"/>&nbsp 
  <img src="https://img.shields.io/badge/Axios-white?style=for-the-badge&logo=Axios&logoColor=black"/>&nbsp 
  <img src="https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white"/>&nbsp 
 </td>
</tr>
  
<tr>
  <td align="center">Backend</td>
  <td>
    <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Spring_data_jpa-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Spring_cloud-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Spring_cloud_Gateway-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Spring_webflux-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">Cloud</td>
  <td>
    <img src="https://img.shields.io/badge/docker-257bd6?style=for-the-badge&logo=docker&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">DataBase</td>
  <td>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">Message Queue</td>
  <td>
    <img src="https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Apache_Zookeeper-231F20?style=for-the-badge&logo=apache-zookeeper&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">Monitoring</td>
  <td>
    <img src="https://img.shields.io/badge/Grafana-F46800?style=for-the-badge&logo=Grafana&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">Testing</td>
  <td>
    <img src="https://img.shields.io/badge/Apache_JMeter-D22128?style=for-the-badge&logo=apache-jmeter&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/>&nbsp 
  </td>
</tr>

<tr>
  <td align="center">CI/CD</td>
  <td>
    <img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white"/>&nbsp
    <img src="https://img.shields.io/badge/GitLab-FC6D26?style=for-the-badge&logo=gitlab&logoColor=white"/>&nbsp
    <img src="https://img.shields.io/badge/ArgoCD-EF7B4D?style=for-the-badge&logo=argo&logoColor=white"/>&nbsp
  </td>
</tr>
  
<tr>
 <td align="center">Cooperation</td>
 <td>
    <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>&nbsp
    <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"/>&nbsp 
    <img src="https://img.shields.io/badge/Notion-5a5d69?style=for-the-badge&logo=Notion&logoColor=white"/>&nbsp
    <img src="https://img.shields.io/badge/Discord-4263f5?style=for-the-badge&logo=Discord&logoColor=white"/>&nbsp 
 </td>
</tr>

<tr>
 <td align="center">IDE</td>
 <td>
    <img src="https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white"/>&nbsp
    <img src="https://img.shields.io/badge/Intellij%20Idea-000?logo=intellij-idea&style=for-the-badge"/>
</tr>

</table>

## 🚀 주요 기능

### 채팅 기능

- **실시간 WebSocket 채팅**: STOMP 프로토콜 사용
- **카프카 기반 메시지 처리**: 비동기 메시지 큐잉
- **일반 채팅**: 직접 DB 저장 방식
- **사용자 관리**: 회원가입/로그인 기능

### 프론트엔드 기능

- **로그인/회원가입**: 사용자 인증 시스템
- **비밀번호 재설정**: 이메일을 통한 비밀번호 재설정
- **반응형 디자인**: 모바일, 태블릿, 데스크톱 지원
- **실시간 채팅 인터페이스**: WebSocket 연결을 통한 실시간 메시지 송수신

### 모니터링 시스템

- **프로메테우스 메트릭 수집**: 애플리케이션 성능 모니터링
- **그라파나 대시보드**: 실시간 성능 시각화
- **카프카 메트릭**: 메시지 처리량, 지연시간 모니터링

### 부하 테스트

- **JMeter WebSocket 테스트**: 대용량 메시지 처리 성능 측정
- **카프카 vs 일반 채팅 비교**: 성능 차이 분석
- **실시간 모니터링**: 테스트 중 시스템 상태 추적

## 🏗️ System Architecture

<div align="center">
  <img width="719" height="472" alt="Kafrika Architecture" src="https://github.com/user-attachments/assets/61b234c6-0557-44b5-9162-83ac34bdcfcc" />
</div>

### 아키텍처 구성 요소

#### 🏢 클라이언트 접근 및 외부 서비스

- **Client**: 최종 사용자
- **Web Browser**: 클라이언트 접근 수단
- **Cloudflare**: CDN 및 보안 서비스 (`http://www.kafika.com`)

#### 🔄 개발 및 CI/CD 파이프라인 (Private Cloud)

- **Dev**: 개발자
- **GitHub**: 코드 저장소
- **Jenkins**: CI 서버 (Private subnet)
- **SonarQube**: 코드 품질 분석
- **Docker Registry**: 빌드 아티팩트 저장
- **ArgoCD**: CD 도구 (k8s Cluster 배포)

#### ⚡ 애플리케이션 런타임 환경 (JCloud Students)

- **k8s Cluster**: 컨테이너 오케스트레이션
- **Kafka Broker**: 분산 메시징 시스템
- **Zookeeper**: 카프카 클러스터 관리
- **Spring Boot**: 백엔드 서비스 (2개 AZ - GPU)
- **PostgreSQL**: 관계형 데이터베이스 (DB subnet)

#### 📊 모니터링 시스템

- **Grafana**: 메트릭 시각화 대시보드
- **Loki**: 로그 수집 및 쿼리
- **Prometheus**: 메트릭 수집 및 경고

#### 🔗 데이터 흐름

- **개발 흐름**: GitHub → Jenkins → SonarQube → Docker Registry → ArgoCD → k8s
- **클라이언트 요청**: Client → Cloudflare → Spring Boot
- **내부 통신**: Spring Boot ↔ PostgreSQL
- **모니터링**: Spring Boot/PostgreSQL → Loki/Prometheus → Grafana

## 📦 설치 및 실행

### 1. 프로젝트 클론

```bash
git clone <repository-url>
cd SpringBoot-Kafka
```

### 2. 전체 서비스 시작 (Docker Compose)

```bash
# 모든 서비스 시작 (백엔드, 프론트엔드, Kafka, 모니터링)
docker-compose up -d
```

### 3. 개별 서비스 실행

#### 백엔드 실행

```bash
cd BE
./gradlew bootRun
```

#### 프론트엔드 실행

```bash
cd FE
npm install
npm start
```

### 4. 서비스 접속

- **프론트엔드**: http://localhost:3000
- **백엔드 API**: http://localhost:8080
- **그라파나 대시보드**: http://localhost:3001
- **프로메테우스**: http://localhost:9090

## 🧪 부하 테스트 실행

### JMeter 카프카 테스트

```bash
cd BE
jmeter -n -t jmeter-tests/final_csv_dynamic_message_for_kafka.jmx -l results/kafka_results.jtl -f
```

### JMeter 일반 채팅 테스트

```bash
cd BE
jmeter -n -t jmeter-tests/final_csv_dynamic_message_for_websocket.jmx -l results/normal_chat_results.jtl -f
```

## 📊 모니터링 메트릭

### 카프카 메트릭

- `kafka_consumer_fetch_manager_records_consumed_total`: 메시지 처리량
- `kafka_consumer_fetch_manager_bytes_consumed_total`: 데이터 처리량
- `kafka_consumer_fetch_manager_records_lag`: 컨슈머 지연

### 애플리케이션 메트릭

- `http_server_requests_seconds_count`: HTTP 요청 수
- `hikaricp_connections`: DB 연결풀 상태
- `jvm_memory_used_bytes`: JVM 메모리 사용량

## 📝 API 문서

### WebSocket 엔드포인트

- **연결**: `ws://localhost:8080/ws`
- **카프카 메시지 전송**: `/pub/kafka-chat`
- **일반 메시지 전송**: `/pub/chat`
- **메시지 구독**: `/topic/chat`

### REST API

- **채팅 로그 조회**: `GET /chat/log`
- **사용자 회원가입**: `POST /user/signup`
- **사용자 로그인**: `POST /user/login`
- **헬스체크**: `GET /actuator/health`

## 📋 API 명세서

### 🔐 인증 API

#### 회원가입

```http
POST /api/auth/signup
Content-Type: application/json

{
  "username": "string",
  "email": "string",
  "password": "string",
  "confirmPassword": "string"
}
```

**응답**

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

#### 로그인

```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "string",
  "password": "string"
}
```

**응답**

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

#### 비밀번호 재설정

```http
POST /api/auth/reset-password
Content-Type: application/json

{
  "email": "string"
}
```

### 💬 채팅 API

#### 채팅 메시지 전송 (일반)

```http
POST /api/chat/send
Authorization: Bearer {accessToken}
Content-Type: application/json

{
  "roomId": "string",
  "message": "string",
  "messageType": "TEXT"
}
```

#### 채팅 메시지 전송 (Kafka)

```http
POST /api/chat/send-kafka
Authorization: Bearer {accessToken}
Content-Type: application/json

{
  "roomId": "string",
  "message": "string",
  "messageType": "TEXT"
}
```

#### 채팅 로그 조회

```http
GET /api/chat/log?roomId={roomId}&page={page}&size={size}
Authorization: Bearer {accessToken}
```

**응답**

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
      "totalPages": 5
    }
  }
}
```

#### 채팅방 생성

```http
POST /api/chat/room
Authorization: Bearer {accessToken}
Content-Type: application/json

{
  "roomName": "string",
  "roomType": "PUBLIC"
}
```

### 👥 사용자 API

#### 사용자 정보 조회

```http
GET /api/user/profile
Authorization: Bearer {accessToken}
```

#### 사용자 정보 수정

```http
PUT /api/user/profile
Authorization: Bearer {accessToken}
Content-Type: application/json

{
  "username": "string",
  "email": "string"
}
```

### 📊 모니터링 API

#### 시스템 상태 조회

```http
GET /actuator/health
```

#### 메트릭 조회

```http
GET /actuator/metrics
```

#### 카프카 메트릭 조회

```http
GET /actuator/metrics/kafka.consumer.records-consumed-total
```

## 📱 화면 캡처

### 🏠 메인 페이지

<div align="center">
  <img width="800" alt="메인 페이지" src="https://github.com/user-attachments/assets/57d1039f-fb61-49c1-8648-64ee509ed2d3" />
</div>

### 🔐 인증 페이지

#### 로그인 페이지

<div align="center">
  <img width="400" alt="로그인 페이지" src="https://github.com/user-attachments/assets/6fd5985a-ac28-4203-838d-e3d29ce2cd1c" />
</div>

#### 회원가입 페이지

<div align="center">
  <img width="400" alt="회원가입 페이지" src="https://github.com/user-attachments/assets/4525443d-b92b-4460-bc7d-1664341db83b"/>
</div>

#### 비밀번호 재설정 페이지

<div align="center">
  <img width="400" alt="비밀번호 재설정 페이지" src="https://github.com/user-attachments/assets/3bf0d5c1-5170-40e1-a806-9d39151ab6af" />
</div>


### 📊 모니터링 대시보드

#### 그라파나 대시보드

<div align="center">
  <img width="800" alt="그라파나 대시보드" src="https://github.com/user-attachments/assets/130d8b69-f8c0-4db3-bb24-a67490d95c33" />
</div>


## 🔧 개발 환경 설정

### 백엔드 환경 변수

```env
# BE/.env
SPRING_PROFILES_ACTIVE=dev
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/kafrika
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
```

### 프론트엔드 환경 변수

```env
# FE/.env
REACT_APP_API_BASE_URL=http://localhost:8080
REACT_APP_WS_URL=ws://localhost:8080/ws
```

## 📈 테스트 결과 예시

### 카프카 부하 테스트 (1000 스레드)

- **총 메시지**: 9,000개
- **처리 시간**: 약 30초
- **평균 TPS**: 300 msg/sec
- **에러율**: 0%

### 일반 채팅 부하 테스트 (1000 스레드)

- **총 메시지**: 9,000개
- **처리 시간**: 약 20초
- **평균 TPS**: 450 msg/sec
- **에러율**: 0%

## 🐛 문제 해결

### 일반적인 문제들

#### 1. 포트 충돌

```bash
# 포트 사용 확인
netstat -tlnp | grep :8080
netstat -tlnp | grep :3000
```

#### 2. Docker 서비스 문제

```bash
# 서비스 상태 확인
docker-compose ps

# 로그 확인
docker-compose logs backend
docker-compose logs frontend
```

#### 3. 카프카 연결 문제

```bash
# 카프카 토픽 확인
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092
```

## 🔮 업데이트 계획

### 📋 단기 계획 (1-2주)

#### 프론트엔드 개선

- [x] **채팅 문의 CRUD 구현**
- [x] **실시간 채팅 상담창 구현**
- [x] **Redux Toolkit 도입**
- [x] **React Query 도입**

#### 백엔드 개선

- [x] **API 문서화 (Swagger)**
- [x] **보안 강화 (JWT, OAuth2)**
- [x] **캐싱 전략 (Redis)**
- [x] **로깅 시스템 개선**

### 🛠 기술적 개선사항

- [x] **CI/CD 파이프라인 구축**
- [x] **테스트 커버리지 80% 이상**
- [x] **성능 최적화**
- [x] **마이크로서비스 아키텍처 전환**

---

© 2025 Won Payments. All Rights Reserved.

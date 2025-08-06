# Kafka Chat Application with JMeter Load Testing

## 📋 프로젝트 개요

Spring Boot 기반의 실시간 채팅 애플리케이션으로, Kafka를 통한 메시지 처리와 JMeter를 활용한 부하 테스트를 포함합니다.

## 📁 프로젝트 구조

```
Kafka-Test/
├── 📁 src/                          # Spring Boot 소스 코드
│   ├── main/java/com/fisa/kafrika_backend/
│   └── main/resources/
├── 📁 jmeter-tests/                  # JMeter 테스트 파일들
│   ├── final_csv_dynamic_message_for_kafka.jmx
│   ├── final_csv_dynamic_message_for_websocket.jmx
│   ├── http_load_test.jmx
│   └── simple_websocket_test.jmx
├── 📁 monitoring/                    # 모니터링 설정 파일들
│   ├── kafka-dashboard-updated.json
│   └── kafka-experiment-dashboard-fixed.json
├── 📁 config/                        # 설정 파일들
│   └── prometheus.yml
├── 📁 scripts/                       # 유틸리티 스크립트들
│   └── clean_test_data.sh
├── 📁 results/                       # 테스트 결과 파일들
├── 📁 Kafrika-Frontend/             # 프론트엔드 (선택사항)
├── 📄 docker-compose.yml            # Docker Compose 설정
├── 📄 docker-compose.light.yml      # 경량 Docker 설정
├── 📄 Dockerfile                    # Docker 이미지 설정
├── 📄 build.gradle                  # Gradle 빌드 설정
├── 📄 users.csv                     # 테스트 데이터
└── 📄 README.md                     # 프로젝트 문서
```

## 🏗️ 아키텍처

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   JMeter        │    │  Spring Boot    │    │     Kafka       │
│   Load Test     │───▶│   Backend       │───▶│   Message Queue │
│                 │    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              │
                              ▼
                       ┌─────────────────┐
                       │   PostgreSQL    │
                       │   Database      │
                       └─────────────────┘
```

## 🚀 주요 기능

### 채팅 기능

- **실시간 WebSocket 채팅**: STOMP 프로토콜 사용
- **카프카 기반 메시지 처리**: 비동기 메시지 큐잉
- **일반 채팅**: 직접 DB 저장 방식
- **사용자 관리**: 회원가입/로그인 기능

### 모니터링 시스템

- **프로메테우스 메트릭 수집**: 애플리케이션 성능 모니터링
- **그라파나 대시보드**: 실시간 성능 시각화
- **카프카 메트릭**: 메시지 처리량, 지연시간 모니터링

### 부하 테스트

- **JMeter WebSocket 테스트**: 대용량 메시지 처리 성능 측정
- **카프카 vs 일반 채팅 비교**: 성능 차이 분석
- **실시간 모니터링**: 테스트 중 시스템 상태 추적

## 🛠️ 기술 스택

### Backend

- **Spring Boot 3.x**: 메인 애플리케이션 프레임워크
- **Spring WebSocket**: 실시간 통신
- **Spring Kafka**: 메시지 큐 처리
- **Spring Data JPA**: 데이터베이스 접근
- **PostgreSQL**: 메인 데이터베이스

### Monitoring

- **Prometheus**: 메트릭 수집
- **Grafana**: 대시보드 시각화
- **Micrometer**: 애플리케이션 메트릭

### Testing

- **JMeter**: 부하 테스트 도구
- **WebSocket Sampler**: WebSocket 테스트

### Infrastructure

- **Docker Compose**: 컨테이너 오케스트레이션
- **Kafka**: 메시지 브로커
- **Zookeeper**: Kafka 클러스터 관리

## 📦 설치 및 실행

### 1. 프로젝트 클론

```bash
git clone <repository-url>
cd Kafka-Test
```

### 2. Docker Compose로 서비스 시작

```bash
docker-compose up -d
```

### 3. 서비스 확인

```bash
# 백엔드 서버
curl http://113.198.66.77:10161/actuator/health

# 그라파나 대시보드
http://113.198.66.77:3000

# 프로메테우스
http://113.198.66.77:443
```

## 🧪 부하 테스트 실행

### JMeter 카프카 테스트

```bash
# 카프카 메시지 부하 테스트
jmeter -n -t jmeter-tests/final_csv_dynamic_message_for_kafka.jmx -l results/kafka_results.jtl -f
```

### JMeter 일반 채팅 테스트

```bash
# 일반 WebSocket 채팅 부하 테스트
jmeter -n -t jmeter-tests/final_csv_dynamic_message_for_websocket.jmx -l results/normal_chat_results.jtl -f
```

### 실시간 모니터링

```bash
# 카프카 메시지 모니터링
docker exec -it kafka kafka-console-consumer --topic chat-message --bootstrap-server localhost:9092

# 백엔드 로그 모니터링
docker logs kafka-backend -f
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

### 시스템 메트릭

- CPU 사용률
- 메모리 사용량
- 네트워크 처리량

## 🔧 설정 파일

### application.yml

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: chat-consumer-group
      auto-offset-reset: earliest

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
```

### docker-compose.yml

```yaml
services:
  kafka:
    image: confluentinc/cp-kafka:7.4.0
    ports:
      - "9092:9092"

  backend:
    build: .
    ports:
      - "8080:8080"

  grafana:
    image: grafana/grafana:latest
    ports:
      - "3000:3000"

  prometheus:
    image: prom/prometheus:latest
    ports:
      - "443:9090"
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

#### 1. JMeter 연결 실패

```bash
# 포트 확인
netstat -tlnp | grep 10161

# 서버 상태 확인
curl http://113.198.66.77:10161/actuator/health
```

#### 2. 카프카 메트릭 "No data"

```bash
# 카프카 토픽 확인
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092

# 메시지 전송 테스트
docker exec -it kafka kafka-console-producer --topic chat-message --bootstrap-server localhost:9092
```

#### 3. 그라파나 대시보드 문제

- 데이터 소스 설정 확인
- 프로메테우스 연결 상태 확인
- 쿼리 문법 검증

## 📝 API 문서

### WebSocket 엔드포인트

- **연결**: `ws://113.198.66.77:10161/ws`
- **카프카 메시지 전송**: `/pub/kafka-chat`
- **일반 메시지 전송**: `/pub/chat`
- **메시지 구독**: `/topic/chat`

### REST API

- **채팅 로그 조회**: `GET /chat/log`
- **사용자 회원가입**: `POST /user/signup`
- **사용자 로그인**: `POST /user/login`
- **헬스체크**: `GET /actuator/health`

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.

## 📞 연락처

프로젝트 관련 문의사항이 있으시면 이슈를 등록해주세요.

---

**Kafka Chat Application** - 실시간 채팅과 부하 테스트를 통한 성능 분석 프로젝트

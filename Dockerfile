# Java 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 래퍼와 필요한 파일들 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# 소스 코드 복사
COPY src src

# 실행 권한 부여 및 빌드
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# JAR 파일 실행
EXPOSE 8080
CMD ["java", "-jar", "build/libs/kafrika_backend-0.0.1-SNAPSHOT.jar"]
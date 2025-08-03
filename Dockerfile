# Java 17 런타임 이미지 사용 (더 가벼움)
FROM eclipse-temurin:17-jre

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일만 복사
COPY build/libs/kafrika_backend-0.0.1-SNAPSHOT.jar app.jar

# 포트 노출
EXPOSE 8080

# JAR 파일 실행
CMD ["java", "-jar", "app.jar"]
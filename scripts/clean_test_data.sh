#!/bin/bash

echo "🧹 테스트 데이터 정리 시작..."

# 1. ChatMessage 테이블 비우기
docker exec postgres-db psql -U kafka_user -d kafka_db -c "TRUNCATE TABLE chat_message CASCADE;"

# 2. PostgreSQL 통계 업데이트
docker exec postgres-db psql -U kafka_user -d kafka_db -c "VACUUM ANALYZE;"

# 3. 현재 상태 확인
echo "📊 정리 후 상태:"
docker exec postgres-db psql -U kafka_user -d kafka_db -c "
SELECT 
    schemaname,
    tablename,
    n_tup_ins as inserts,
    n_tup_upd as updates,
    n_tup_del as deletes
FROM pg_stat_user_tables 
WHERE tablename IN ('chat_message', 'users', 'chat_room');
"

echo "✅ 데이터 정리 완료!"
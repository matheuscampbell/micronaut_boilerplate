.PHONY: up down build run test fmt

up:
docker compose -f docker-compose.dev.yml up -d
sleep 5
docker exec -i $$(docker ps -qf name=mongo) mongosh --eval 'rs.initiate()' || true
docker exec -i $$(docker ps -qf name=mongo) mongosh --eval 'rs.status()'

down:
docker compose -f docker-compose.dev.yml down -v

build:
mvn -q -T1C -DskipTests package

run:
mvn -q -pl modules/api -am mn:run

test:
mvn -q -DskipITs=false test

fmt:
mvn spotless:apply

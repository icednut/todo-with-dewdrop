# Todo App Backend Application 연습하기
- Java와 Dewdrop을 이용하여 Todo App을 Event Sourcing 기법으로 구현해보자.
- 이 프로젝트는 Event Sourcing을 이해하기 위한 연습 프로젝트라고 생각하자.

## Use case
- Todo 항목을 등록할 수 있어야 한다.
    - Todo 항목의 하위 항목을 등록할 수 있어야 한다.
- Todo 항목을 수정할 수 있어야 한다.
- Todo 항목을 삭제할 수 있어야 한다.

## Build
```
./gradlew build
```

## Test
```
./gradlew test
```

## Local Run
```
docker-compose up -d
./gradlew bootRun
```

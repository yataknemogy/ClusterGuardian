
# ClusterGuardian

ClusterGuardian는 클러스터 노드를 관리하고 모니터링하기 위해 설계된 Spring Boot 애플리케이션입니다. 이 애플리케이션은 데이터베이스 백업 생성, 데이터 복원 및 REST API를 통한 클러스터 노드 관리를 위한 기능을 제공합니다.

## 요구 사항

- Docker 및 Docker Compose
- Java 17
- Gradle
- PostgreSQL 13

## 설치 및 실행

### 1. 리포지토리 클론

```bash
git clone https://github.com/yataknemogy/ClusterGuardian.git
cd ClusterGuardian
```

### 2. 환경 변수 설정
`docker-compose.yml` 및 `application.properties`에서 환경 변수가 올바르게 구성되어 있는지 확인하십시오.

### 3. Docker를 사용하여 애플리케이션 빌드 및 실행

애플리케이션을 Docker에서 빌드하고 실행하려면 다음 명령을 실행하십시오:

`
docker-compose up --build
`

### 4. 애플리케이션에 액세스

애플리케이션은 `http://localhost:8080` 에서 액세스할 수 있습니다.

## 사용법

### API 엔드포인트

- 클러스터 노드:
    - `GET /api/nodes`: 모든 클러스터 노드 가져오기
    - `POST /api/nodes`: 새 클러스터 노드 추가
    - `GET /api/nodes/{id}`: ID로 클러스터 노드 가져오기
    - `PUT /api/nodes/{id}`: ID로 클러스터 노드 업데이트
    - `DELETE /api/nodes/{id}`: ID로 클러스터 노드 삭제

- 백업:
    - `POST /api/backup/create`: 데이터베이스 백업 생성
    - `POST /api/backup/restore`: 백업에서 데이터베이스 복원

## WebSocket 엔드포인트
- 노드 상태 업데이트:
    - `ws://localhost:8080/ws/node-status`: 클러스터 노드 상태의 실시간 업데이트를 구독합니다.

WebSocket 연결을 통해 클라이언트는 클러스터 노드 상태가 변경될 때마다 실시간 업데이트를 받을 수 있습니다.

## 테스트

### 유닛 테스트

이 프로젝트에는 JUnit 및 Mockito를 사용하여 작성된 유닛 테스트가 포함되어 있습니다. 이를 실행하려면 다음을 사용하십시오: `./gradlew test`.

### WebSocket 테스트

WebSocket 기능은 `ClusterNodeWebSocketTest` 클래스에서 제공된 유닛 테스트를 사용하여 테스트할 수 있습니다. 애플리케이션이 실행 중인지 확인하고 테스트를 실행하십시오:

`
./gradlew test
`

### Docker 테스트

컨테이너 내에서 애플리케이션의 기능을 확인하려면 모든 컨테이너가 실행 중인지 확인하고 데이터베이스 연결 및 기본 API 요청에 대한 테스트를 수행하십시오.

## 디버깅

디버깅 모드를 활성화하려면 `application.properties`에 다음을 추가하십시오:

```
logging.level.root=DEBUG
```

또는 다음 명령을 사용하여 애플리케이션을 실행하십시오:

`
./gradlew bootRun --args='--debug'
`

## 배포

이 애플리케이션은 Docker를 지원하는 모든 서버에 배포할 수 있으며, Kubernetes 클러스터에서도 배포할 수 있습니다.

## 라이선스

이 프로젝트는 MIT 라이선스 하에 라이선스가 부여됩니다 – 자세한 내용은 [LICENSE](/LICENSE.md) 파일을 참조하십시오.

## 다른 언어로 읽기

[EN](/README.md) | [RU](README_RU.md) | [FR](README_FR.md) | [JP](README_JP.md) | [DE](README_DE.md) | [CH](README_CH.md) | [KR](README_KR.md)

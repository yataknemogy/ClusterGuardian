# ClusterGuardian

ClusterGuardian is a Spring Boot application designed for managing and monitoring cluster nodes. The application includes features for database backup creation, data restoration, and cluster node management through a REST API.

## Requirements

- Docker and Docker Compose
- Java 17
- Gradle
- PostgreSQL 13

## Installation and Running

### 1. Clone the Repository

```bash
git clone https://github.com/yataknemogy/ClusterGuardian.git
cd ClusterGuardian
```

### 2. Set up Environment Variables
Ensure that the environment variables are correctly configured in `docker-compose.yml` and `application.properties`.

### 3. Build and Run Using Docker

To build and run the application in Docker, execute the following commands:

`
docker-compose up --build
`

### 4. Access the Application

The application will be accessible at `http://localhost:8080`.

## Usage

### API Endpoints

- Cluster Nodes:
  - `GET /api/nodes`: Get all cluster nodes
  - `POST /api/nodes`: Add a new cluster node
  - `GET /api/nodes/{id}`: Get a cluster node by ID
  - `PUT /api/nodes/{id}`: Update a cluster node by ID
  - `DELETE /api/nodes/{id}`: Delete a cluster node by ID

-  Backup:
    - `POST /api/backup/create`: Create a database backup
    - `POST /api/backup/restore`: Restore the database from a backup

## WebSocket Endpoints
- Node Status Updates:
    - `ws://localhost:8080/ws/node-status`: Subscribe to real-time updates of cluster node statuses.

The WebSocket connection allows clients to receive real-time updates whenever the status of a cluster node changes.

## Testing

### Unit Tests

The project includes unit tests written using JUnit and Mockito. To run them, use: `./gradlew test`.

### WebSocket Tests

WebSocket functionality can be tested using the provided unit tests in the `ClusterNodeWebSocketTest` class. Ensure the application is running, and execute the tests:

`
./gradlew test
`

### Dockers Tests

To verify the application's functionality within containers, ensure all containers are running, and perform tests on database connections and basic API requests.

## Debugging

To enable debugging mode, add the following to `application.properties`:
```
logging.level.root=DEBUG
```

Or run the application with the following command:

`
./gradlew bootRun --args='--debug'
`

## Deployment

The application can be deployed on any server supporting Docker or in a Kubernetes cluster.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details.

## Read in Other Languages

[RU](docs/README_RU.md) | [FR](docs/README_FR.md) | [JP](docs/README_JP.md) | [DE](docs/README_DE.md) | [CH](docs/README_CH.md) | [KR](docs/README_KR.md)
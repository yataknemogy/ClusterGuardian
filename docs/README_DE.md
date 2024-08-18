# ClusterGuardian

ClusterGuardian ist eine Spring Boot-Anwendung, die zur Verwaltung und Überwachung von Clusternodes entwickelt wurde. Die Anwendung bietet Funktionen zur Erstellung von Datenbank-Backups, zur Wiederherstellung von Daten sowie zur Verwaltung von Clusternodes über eine REST-API.

## Anforderungen

- Docker und Docker Compose
- Java 17
- Gradle
- PostgreSQL 13

## Installation und Ausführung

### 1. Repository klonen

```bash
git clone https://github.com/yataknemogy/ClusterGuardian.git
cd ClusterGuardian
```

### 2. Umgebungsvariablen einrichten
Stellen Sie sicher, dass die Umgebungsvariablen in `docker-compose.yml` und  `application.properties` korrekt konfiguriert sind.

### 3. Anwendung mit Docker bauen und ausführen

Um die Anwendung in Docker zu bauen und auszuführen, führen Sie folgende Befehle aus:


`
docker-compose up --build
`

### 4. Zugriff auf die Anwendung

Die Anwendung ist unter `http://localhost:8080` zugänglich.

## Verwendung

### API-Endpunkte

- Clusternodes:
    - `GET /api/nodes`: Alle Clusternodes abrufen
    - `POST /api/nodes`: Einen neuen Clusternode hinzufügen
    - `GET /api/nodes/{id}`: Einen Clusternode nach ID abrufen
    - `PUT /api/nodes/{id}`: Einen Clusternode nach ID aktualisieren
    - `DELETE /api/nodes/{id}`: Einen Clusternode nach ID löschen

-  Backup:
    - `POST /api/backup/create`: Ein Datenbank-Backup erstellen
    - `POST /api/backup/restore`: Die Datenbank aus einem Backup wiederherstellen

## WebSocket-Endpunkte
- Node Status Updates:
    - `ws://localhost:8080/ws/node-status`: Abonnieren Sie Echtzeit-Updates der Clusternode-Status.

Die WebSocket-Verbindung ermöglicht es Clients, Echtzeit-Updates zu erhalten, wann immer sich der Status eines Clusternodes ändert.

## Tests

### Unit-Tests


Das Projekt enthält Unit-Tests, die mit JUnit und Mockito geschrieben wurden. Um diese auszuführen, verwenden Sie: `./gradlew test`.

### WebSocket-Tests

Die WebSocket-Funktionalität kann mit den bereitgestellten Unit-Tests in der Klasse `ClusterNodeWebSocketTest` getestet werden. Stellen Sie sicher, dass die Anwendung läuft, und führen Sie die Tests aus:

`
./gradlew test
`

### Docker-Tests

Um die Funktionalität der Anwendung in Containern zu überprüfen, stellen Sie sicher, dass alle Container laufen, und führen Sie Tests zu Datenbankverbindungen und grundlegenden API-Anfragen durch.

## Debugging

Um den Debugging-Modus zu aktivieren, fügen Sie Folgendes in `application.properties` hinzu:

```
logging.level.root=DEBUG
```

Oder führen Sie die Anwendung mit folgendem Befehl aus:

`
./gradlew bootRun --args='--debug'
`

## Bereitstellung

Die Anwendung kann auf jedem Server bereitgestellt werden, der Docker unterstützt, oder in einem Kubernetes-Cluster.

## Lizenz

Dieses Projekt ist unter der MIT-Lizenz lizenziert – siehe die [LICENSE](/LICENSE.md)-Datei für Details.

## In anderen Sprachen lesen

[EN](/README.md) | [RU](README_RU.md) | [FR](README_FR.md) | [JP](README_JP.md) | [DE](README_DE.md) | [CH](README_CH.md) | [KR](README_KR.md)
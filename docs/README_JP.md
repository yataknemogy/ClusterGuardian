
# ClusterGuardian

ClusterGuardianは、クラスターノードを管理および監視するために設計されたSpring Bootアプリケーションです。このアプリケーションは、データベースバックアップの作成、データ復元、およびREST APIを介したクラスターノード管理の機能を提供します。

## 必要条件

- Docker および Docker Compose
- Java 17
- Gradle
- PostgreSQL 13

## インストールと実行

### 1. リポジトリのクローン

```bash
git clone https://github.com/yataknemogy/ClusterGuardian.git
cd ClusterGuardian
```

### 2. 環境変数の設定
docker-compose.yml および application.properties で環境変数が正しく設定されていることを確認してください。

### 3. Dockerを使用してアプリケーションをビルドおよび実行

Dockerでアプリケーションをビルドして実行するには、次のコマンドを実行します:

`docker-compose up --build`

### 4. アプリケーションへのアクセス

アプリケーションは `http://localhost:8080` でアクセスできます。

## 使用方法

### APIエンドポイント

- クラスターノード:
    - `GET /api/nodes`: すべてのクラスターノードを取得
    - `POST /api/nodes`: 新しいクラスターノードを追加
    - `GET /api/nodes/{id}`: IDでクラスターノードを取得
    - `PUT /api/nodes/{id}`: IDでクラスターノードを更新
    - `DELETE /api/nodes/{id}`: IDでクラスターノードを削除

- バックアップ:
    - `POST /api/backup/create`: データベースバックアップを作成
    - `POST /api/backup/restore`: バックアップからデータベースを復元

## WebSocketエンドポイント
- ノードステータスの更新:
    - `ws://localhost:8080/ws/node-status`: クラスターノードのステータスのリアルタイム更新を購読します。

WebSocket接続を使用すると、クラスターノードのステータスが変更されるたびにクライアントがリアルタイムの更新を受信できます。

## テスト

### ユニットテスト

このプロジェクトには、JUnitおよびMockitoを使用して作成されたユニットテストが含まれています。これらを実行するには、次を使用します: `./gradlew test`

### WebSocketテスト

WebSocket機能は、ClusterNodeWebSocketTestクラスで提供されるユニットテストを使用してテストできます。アプリケーションが実行中であることを確認し、テストを実行します:

`./gradlew test`

### Dockerテスト

コンテナ内でアプリケーションの機能を確認するには、すべてのコンテナが実行中であることを確認し、データベース接続および基本的なAPIリクエストに対するテストを実行します。

## デバッグ

デバッグモードを有効にするには、`application.properties` に次の行を追加します:

```
logging.level.root=DEBUG
```

または次のコマンドを使用してアプリケーションを実行します:

`./gradlew bootRun --args='--debug'`

## デプロイ

このアプリケーションは、DockerをサポートするサーバーまたはKubernetesクラスターにデプロイできます。

## ライセンス

このプロジェクトはMITライセンスの下でライセンスされています - 詳細は [LICENSE](/LICENSE.md) ファイルを参照してください。

## 他の言語で読む

[RU](docs/README_RU.md) | [FR](docs/README_FR.md) | [JP](docs/README_JP.md) | [DE](docs/README_DE.md) | [CH](docs/README_CH.md) | [KR](docs/README_KR.md)

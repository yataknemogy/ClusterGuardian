
# ClusterGuardian

ClusterGuardian 是一个基于 Spring Boot 的应用程序，旨在管理和监控集群节点。该应用程序包括通过 REST API 创建数据库备份、数据恢复和管理集群节点的功能。

## 要求

- Docker 和 Docker Compose
- Java 17
- Gradle
- PostgreSQL 13

## 安装与运行

### 1. 克隆仓库

```bash
git clone https://github.com/yataknemogy/ClusterGuardian.git
cd ClusterGuardian
```

### 2. 设置环境变量
确保环境变量在 `docker-compose.yml` 和 `application.properties` 中正确配置。

### 3. 使用 Docker 进行构建和运行

要在 Docker 中构建并运行应用程序，请执行以下命令：

`
docker-compose up --build
`

### 4. 访问应用程序

应用程序将在 `http://localhost:8080` 上访问。

## 使用

### API 端点

- 集群节点:
    - `GET /api/nodes`: 获取所有集群节点
    - `POST /api/nodes`: 添加新集群节点
    - `GET /api/nodes/{id}`: 通过 ID 获取集群节点
    - `PUT /api/nodes/{id}`: 通过 ID 更新集群节点
    - `DELETE /api/nodes/{id}`: 通过 ID 删除集群节点

- 备份:
    - `POST /api/backup/create`: 创建数据库备份
    - `POST /api/backup/restore`: 从备份中恢复数据库

## WebSocket 端点
- 节点状态更新:
    - `ws://localhost:8080/ws/node-status`: 订阅集群节点状态的实时更新。

WebSocket 连接允许客户端在集群节点状态发生变化时实时接收更新。

## 测试

### 单元测试

项目包括使用 JUnit 和 Mockito 编写的单元测试。要运行这些测试，请使用:

`./gradlew test`

### WebSocket 测试

WebSocket 功能可以使用 ClusterNodeWebSocketTest 类中提供的单元测试进行测试。确保应用程序正在运行，然后执行测试:

`./gradlew test`

### Docker 测试

要验证容器内应用程序的功能，请确保所有容器正在运行，并执行数据库连接和基本 API 请求的测试。

## 调试

要启用调试模式，请在 `application.properties` 中添加以下内容:

```
logging.level.root=DEBUG
```

或使用以下命令运行应用程序:

`./gradlew bootRun --args='--debug'`

## 部署

该应用程序可以部署在支持 Docker 的任何服务器或 Kubernetes 集群中。

## 许可证

此项目已获得 MIT 许可证 - 有关详细信息，请参阅 [LICENSE](/LICENSE.md) 文件。

## 以其他语言阅读

[EN](/README.md) | [RU](README_RU.md) | [FR](README_FR.md) | [JP](README_JP.md) | [DE](README_DE.md) | [CH](README_CH.md) | [KR](README_KR.md)

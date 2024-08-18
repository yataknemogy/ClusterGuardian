
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/ClusterGuardian-0.0.1-SNAPSHOT.jar /app/ClusterGuardian.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ClusterGuardian.jar"]

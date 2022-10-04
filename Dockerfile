# syntax=docker/dockerfile:1
FROM openjdk:11
COPY target/backend-service-0.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
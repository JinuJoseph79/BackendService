# syntax=docker/dockerfile:1
#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim
COPY ./  ./
RUN mvn clean package
CMD ["java", "-jar", "target/backend-service-0.0.0-SNAPSHOT.jar"]
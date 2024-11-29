FROM maven:3.8.5-openjdk-17 AS MAVEN_BUILD

RUN mvn -Dmaven.test.skip=true package

FROM openjdk:17-jdk-alpine
LABEL maintainer=neckcode.github.io
COPY target/todolist-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

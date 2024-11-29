FROM openjdk:17-jdk-alpine
LABEL maintainer=neckcode.github.io
COPY target/todolist-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

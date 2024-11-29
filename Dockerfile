FROM openjdk:17-jdk-alpine
LABEL maintainer=mcnz.com
COPY target/todolist-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

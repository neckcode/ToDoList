FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/todolist-0.0.1.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

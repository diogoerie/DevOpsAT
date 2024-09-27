FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Cliente-0.0.1-SNAPSHOT.jar /app/cliente.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "cliente.jar", "app.jar"]

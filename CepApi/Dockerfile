FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/CepApi-0.0.1-SNAPSHOT.jar /app/cepapi.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "cepapi.jar", "app.jar"]

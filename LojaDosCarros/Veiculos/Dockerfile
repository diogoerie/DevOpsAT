FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Veiculos-0.0.1-SNAPSHOT.jar /app/veiculos.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "veiculos.jar", "app.jar"]

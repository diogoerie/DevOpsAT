FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Pedidos-0.0.1-SNAPSHOT.jar /app/pedidos.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "pedidos.jar", "app.jar"]

FROM openjdk:21-slim
WORKDIR /app
COPY target/order-service-0.0.2-SNAPSHOT.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

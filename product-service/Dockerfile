# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the Spring Boot JAR into the image
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
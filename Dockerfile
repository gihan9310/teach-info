FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy your JAR file into the container
COPY build/libs/application.jar app.jar

# Expose the application port (optional)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
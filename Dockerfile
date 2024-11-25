# Start with a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/internal-management-0.1.jar  internal-management-0.1.jar

# Expose the application port (default is 8080)
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "internal-management-0.1.jar"]

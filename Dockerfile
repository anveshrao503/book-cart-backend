# Use an official JDK base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/BookCartApp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

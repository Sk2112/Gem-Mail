# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Add metadata
LABEL maintainer="your-name"

# Set environment variables (you can override them later)
ENV GEMINI_API_URL="https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" 
ENV GEMINI_API_KEY="AIzaSyCvnDtwV-s5ymnLwuO2XZtY5VsD3It90XM"

# Create app directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Expose port (optional, but good practice)
EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]

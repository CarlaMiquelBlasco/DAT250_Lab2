# Stage 1: Build the application using Gradle
FROM gradle:7.5.1-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy only the necessary files to cache dependencies
COPY build.gradle.kts settings.gradle.kts /app/

# Download Gradle dependencies to cache them in this layer
RUN gradle build --no-daemon || return 0

# Copy the rest of the application code
COPY . /app/

# Build the Spring Boot application
RUN gradle bootJar --no-daemon

# Stage 2: Package the application in a minimal image
FROM eclipse-temurin:17-jre-alpine AS runtime

# Create a non-root user to run the app
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Change ownership to the non-root user
RUN chown -R appuser:appgroup /app

# Switch to the non-root user
USER appuser

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "/app/app.jar"]

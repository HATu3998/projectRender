# Use the Maven image for building the application
FROM maven:3.8.5-openjdk-17 AS build

# Copy the entire project to the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests


# Use a lightweight JRE-based image for the runtime
FROM openjdk:17.0.1-jdk-slim

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /target/RenderProject-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8080

# Set the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]

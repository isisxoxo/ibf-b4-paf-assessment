## FIRST CONTAINER
# Build container
FROM openjdk:21-jdk-bullseye AS builder

# Create a directory for our application
WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN /app/mvnw package -Dmaven.test.skip=true

## SECOND CONTAINER
# Run container
FROM openjdk:21-jdk-bullseye

WORKDIR /app_run

# Copying file from builder instead of locally
COPY --from=builder /app/target/batch4-0.0.1-SNAPSHOT.jar .

# Run
ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar batch4-0.0.1-SNAPSHOT.jar
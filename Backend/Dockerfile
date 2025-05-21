# -------------------- Stage 1: Build --------------------
FROM gradle:8.5-jdk AS builder

LABEL maintainer="Nirmalya Mondal <nirmalya2607@google.com>"
LABEL stage="builder"

WORKDIR /app

COPY --chown=gradle:gradle . .

RUN gradle clean build -x --no-daemon

# -------------------- Stage 2: Runtime --------------------
FROM eclipse-temurin:17-jdk-alpine AS runtime

# Metadata
LABEL maintainer="Nirmalya Mondal <nirmalya@example.com>"
LABEL org.opencontainers.image.source="https://github.com/your-repo/springauthapp"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.title="SpringAuthApp"
LABEL org.opencontainers.image.description="A secure Spring Boot login and registration app deployed via EKS"

# Create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

# Copy JAR from build stage (adjust JAR name if needed)
COPY --from=builder /app/build/libs/springauthapp-0.0.1-SNAPSHOT.jar /app/app.jar

# Set ownership and permissions
RUN chown -R appuser:appgroup /app && chmod 755 /app/app.jar

# Run as non-root user
USER appuser

# Expose app port
EXPOSE 8080

# Enable tmp for Spring Boot
VOLUME /tmp

# Environment flags (adjust as needed)
ENV JAVA_OPTS="-XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"

# Run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
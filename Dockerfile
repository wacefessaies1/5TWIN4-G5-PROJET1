# Stage 1: Build Stage
FROM maven:3.6.3-openjdk-8 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ src/
RUN mvn package

# Stage 2: Production Stage
FROM openjdk:8-jre-slim
EXPOSE 8082
COPY --from=builder /app/target/gestion-station-ski-1.0.jar /gestion-station-ski-1.0.jar
ENV JAVA_OPTS="-Dlogging.level.org.springframework.security=DEBUG -Djdk.tls.client.protocols=TLSv1.2"
ENTRYPOINT ["java", "-jar", "/gestion-station-ski-1.0.jar"]

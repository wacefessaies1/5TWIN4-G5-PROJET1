FROM openjdk:11 AS builder
WORKDIR /app
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline
COPY src/ src/
RUN --mount=type=cache,target=/root/.m2 mvn package

FROM openjdk:11-jre-slim
EXPOSE 8089
COPY --from=builder /app/target/gestion-station-ski-1.0.jar /gestion-station-ski-1.0.jar
ENV JAVA_OPTS="-Dlogging.level.org.springframework.security=DEBUG -Djdk.tls.client.protocols=TLSv1.2"
ENTRYPOINT ["java", "-jar", "/gestion-station-ski-1.0.jar"]
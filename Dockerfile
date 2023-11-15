FROM openjdk:11
EXPOSE 8089:8089
#ADD target/gestion-station-ski-1.0.jar gestion-station-ski-1.0.jar
RUN apt-get update && apt-get install -y curl
RUN curl -o timesheet.jar -L "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/spring/gestion-station-ski/1.0/gestion-station-ski-1.0.jar"
ENTRYPOINT ["java", "-jar", "gestion-station-ski-1.0.jar"]
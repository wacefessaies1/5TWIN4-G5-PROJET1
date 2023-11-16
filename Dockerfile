FROM openjdk:11
EXPOSE 8089:8089
RUN apt-get update && apt-get install -y curl
RUN curl -o gestion-station-ski-1.0.jar -L "http://192.168.37.143:8081/repository/maven-releases/tn/esprit/spring/gestion-station-ski/1.0/gestion-station-ski-1.0.jar"
ENTRYPOINT ["java", "-jar", "gestion-station-ski-1.0.jar"]
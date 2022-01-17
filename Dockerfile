FROM openjdk:latest
COPY target/davetlimsinizRest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

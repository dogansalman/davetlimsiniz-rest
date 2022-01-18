FROM openjdk:latest
COPY target/davetlimsiniz-rest.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:15-alpine
ADD target/contextinfo-webservice-0.0.1-SNAPSHOT.jar contextinfo-api.jar
EXPOSE 5052
ENTRYPOINT ["java", "-jar","/contextinfo-api.jar"]
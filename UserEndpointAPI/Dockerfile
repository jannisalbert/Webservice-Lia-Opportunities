FROM openjdk:15-alpine
ADD target/UserEndpoint-webservice-0.0.1-SNAPSHOT.jar userendpoint-api.jar
EXPOSE 5054
ENTRYPOINT ["java", "-jar","/userendpoint-api.jar"]
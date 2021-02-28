FROM openjdk:15-alpine
ADD target/opportunities-webservice-0.0.1-SNAPSHOT.jar opportunities-api.jar
EXPOSE 5053
ENTRYPOINT ["java", "-jar","/opportunities-api.jar"]
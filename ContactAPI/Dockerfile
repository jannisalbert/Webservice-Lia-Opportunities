FROM openjdk:15-alpine
ADD target/company-webservice-0.0.1-SNAPSHOT.jar companies-api.jar
EXPOSE 5050
ENTRYPOINT ["java", "-jar","/companies-api.jar"]
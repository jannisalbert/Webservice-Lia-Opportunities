FROM openjdk:15-alpine
ADD target/contact-webservice-0.0.1-SNAPSHOT.jar contact-api.jar
EXPOSE 5051
ENTRYPOINT ["java", "-jar","/contact-api.jar"]
FROM openjdk:17-jdk-slim-buster

WORKDIR /app
COPY ./target/profeRestFull-0.0.1-SNAPSHOT.jar /app

EXPOSE 8085

CMD ["java", "-jar", "mvcThJpa-0.0.2.jar"]
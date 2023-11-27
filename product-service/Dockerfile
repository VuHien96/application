FROM maven:3.8.3-openjdk-17

RUN mvn clean install

FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} productservice.jar

ENTRYPOINT ["java", "-jar", "/productservice.jar"]

EXPOSE 8080
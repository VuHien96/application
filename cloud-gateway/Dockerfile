FROM maven:3.8.3-openjdk-17

RUN mvn clean install

FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} cloudgateway.jar

ENTRYPOINT ["java", "-jar", "cloudgateway.jar"]

EXPOSE 9090
FROM openjdk:17-jdk-slim as build
MAINTAINER mtopgul
COPY target/notification-service-1.0-SNAPSHOT.jar notification-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/notification-service-1.0-SNAPSHOT.jar"]
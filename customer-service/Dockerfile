FROM openjdk:17-jdk-slim as build
MAINTAINER mtopgul
COPY target/customer-service-1.0-SNAPSHOT.jar customer-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customer-service-1.0-SNAPSHOT.jar"]
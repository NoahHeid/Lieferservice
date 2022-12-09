FROM openjdk:19
EXPOSE 8080
MAINTAINER Noah Heidrich
COPY target/Deliveryservice-0.0.1.jar deliveryservice.jar
ENTRYPOINT ["java","-jar","/deliveryservice.jar"]

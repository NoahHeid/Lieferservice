FROM openjdk:19
FROM maven:alpine

# image layer
WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean

# Image layer: with the application
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080

ADD ./target/Deliveryservice-0.0.1.jar /dev/
ENTRYPOINT ["java","-jar","/dev/deliveryservice.jar"]

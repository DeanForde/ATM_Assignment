FROM openjdk:latest

ADD target/demo.jar demo.jar

ENTRYPOINT ["java", "-jar", "/demo.jar"]

EXPOSE 8080
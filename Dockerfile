FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/kaddem-0.0.1.jar kaddem-0.0.1.jar
ENTRYPOINT ["java","-jar","/Kaddem.jar"]

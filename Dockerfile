FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/kaddem.jar kaddem.jar
ENTRYPOINT ["java","-jar","Kaddem.jar"]

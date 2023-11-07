FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/devops.jar devops.jar
ENTRYPOINT ["java","-jar","devops.jar"]
FROM openjdk:8
EXPOSE 8080
ADD target/Kaddem-0.0.1.jar Kaddem-0.0.1.jar
ENTRYPOINT ["java","-jar","Kaddem-0.0.1.jar"]
FROM openjdk:8
EXPOSE 8080
COPY target/Kaddem-0.0.1.jar Kaddem-0.0.1.jar
ENTRYPOINT ["java","-jar","Kaddem-0.0.1.jar"]
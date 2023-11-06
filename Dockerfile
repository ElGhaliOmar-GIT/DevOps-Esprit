#FROM openjdk:8
#EXPOSE 8080
#COPY target/kaddem-0.0.1.jar Kaddem-0.0.1.jar
#ENTRYPOINT ["java","-jar","Kaddem-0.0.1.jar"]

FROM openjdk:8-jdk-alpine
# Use the official OpenJDK base image
FROM openjdk:8-jdk-alpine

# Add your JAR file from the local filesystem to the image
ADD target/kaddem-1.0.jar app.jar

# Expose the port your application will run on
EXPOSE 8089

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]

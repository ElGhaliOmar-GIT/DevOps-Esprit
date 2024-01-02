FROM openjdk:8-jdk-alpine
# Use the official OpenJDK base image
FROM openjdk:8-jdk-alpine


ADD target/kaddem-1.0.jar app.jar

# Expose the port my application will run on
EXPOSE 8089

# Define the command app.jar to run my application
CMD ["java", "-jar", "app.jar"]
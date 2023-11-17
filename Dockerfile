FROM openjdk:8-jdk-alpine
# Use the official OpenJDK base image
FROM openjdk:8-jdk-alpine

# j'ai conteunarisé ma app kaddem-1.0 et je le met dans app.jar
#et j'ai récupére le jar a partir du dossier target
ADD target/kaddem-1.0.jar app.jar

# Expose the port my application will run on
EXPOSE 8089

# Define the command app.jar to run my application
CMD ["java", "-jar", "app.jar"]
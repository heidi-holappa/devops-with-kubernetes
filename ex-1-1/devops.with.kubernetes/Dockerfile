FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy your built JAR into the image
COPY target/devops.with.kubernetes-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

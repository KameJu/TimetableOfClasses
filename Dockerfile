FROM openjdk:latest
ADD target/TimetableOfClasses-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
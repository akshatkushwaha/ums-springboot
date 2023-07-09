# OpenJDK 17
# Gradle 7.2
# Alpine Linux

FROM openjdk:17-jdk-alpine

# set working directory
WORKDIR /server

# copy build.gradle and settings.gradle
COPY build.gradle settings.gradle gradlew /server/

# copy gradle folder
COPY gradle /server/gradle

# copy src folder
COPY src /server/src

# build
RUN ./gradlew build -x test

Expose 8080 8080

# run
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
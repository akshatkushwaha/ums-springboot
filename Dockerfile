# OpenJDK 17
# Gradle 7.2
# Alpine Linux

FROM openjdk:17-jdk-alpine

# set working directory
WORKDIR /web

# copy build.gradle and settings.gradle
COPY build.gradle settings.gradle gradlew /web/

# copy gradle folder
COPY gradle /web/gradle

# copy src folder
COPY src /web/src

# build
RUN ./gradlew build -x test

Expose 8080 8080

# run
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
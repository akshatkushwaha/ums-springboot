FROM openjdk:17-jdk-slim

#WORKDIR /
#
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#
#COPY src ./src
#
#RUN ./mvnw dependency:go-offline
#
#RUN ./mvnw package -DskipTests
#
#WORKDIR /server
#
#CMD ["java", "-jar", "University-Management-System-0.0.1-SNAPSHOT.jar"]

WORKDIR /usr/server

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

COPY src ./src

RUN ./mvnw dependency:go-offline

RUN ./mvnw package -DskipTests

CMD ["java", "-jar", "target/University-Management-System-0.0.1-SNAPSHOT.jar"]
FROM maven:3.8.5-openjdk-17-slim as build

COPY src /usr/src
COPY pom.xml /usr

WORKDIR /usr

RUN mvn clean package

FROM maven:3.8.5-eclipse-temurin-17-focal as base

WORKDIR /usr

COPY --from=build /usr/target/mysbapp-1.0.0-SNAPSHOT.jar /usr/mysbapp-1.0.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/mysbapp-1.0.0-SNAPSHOT.jar"]

FROM maven:3.3-jdk-8-alpine AS MAVEN_IMAGE
WORKDIR /app
ADD pom.xml /app
RUN mvn -e -U dependency:go-offline  --fail-never

COPY src /app/src
RUN mvn -e -U verify

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=MAVEN_IMAGE /app/target/*.jar /app/target/app.jar
ENTRYPOINT ["java", "-jar", "target/app.jar"]
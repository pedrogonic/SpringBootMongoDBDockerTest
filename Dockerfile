FROM maven:alpine AS MAVEN_IMAGE

WORKDIR /app
ADD pom.xml /app
# ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn -v
RUN mvn verify

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=MAVEN_IMAGE /app/target/*.jar /app/target/app.jar
ENTRYPOINT ["java", "-jar", "target/app.jar"]
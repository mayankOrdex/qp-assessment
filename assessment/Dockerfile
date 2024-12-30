FROM jelastic/maven:3.9.5-openjdk-21 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:21-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/assessment-0.0.1-SNAPSHOT.war /app/
ENTRYPOINT ["java", "-jar", "assessment-0.0.1-SNAPSHOT.war"]

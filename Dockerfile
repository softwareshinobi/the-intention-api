FROM maven:3.8.7-openjdk-18-slim AS mavenPackage

WORKDIR /

COPY . .

RUN mvn install

FROM eclipse-temurin:18-jre-alpine

COPY --from=mavenPackage /target/the-intention-app-api-1.0.jar /the-intention-app-api-1.0.jar

COPY --from=mavenPackage /src/main/resources/application.properties /application.properties

CMD ["java", "-jar", "/the-intention-app-api-1.0.jar"] 

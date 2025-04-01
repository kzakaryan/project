FROM alpine:latest AS base

RUN apk add git openjdk21

WORKDIR /app

COPY . /app

RUN ./mvnw clean package
RUN cp capstone-web/target/capstone-web-0.0.3-SNAPSHOT.jar ./app-jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-jar"]
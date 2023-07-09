#FROM openjdk:17-oracle
#MAINTAINER mgelios
#COPY ./main/build/libs/main.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM alpine:latest as jre-prepare-stage
RUN apk add --update openjdk17-jre

FROM jre-prepare-stage as build-stage
COPY ./main/build/libs/main.jar app.jar

FROM build-stage
CMD ["java", "-jar", "/app.jar"]
EXPOSE 8080

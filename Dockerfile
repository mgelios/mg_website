FROM openjdk:17-oracle
MAINTAINER mgelios
COPY ./main/build/libs/main.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
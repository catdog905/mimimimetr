FROM gradle:8.5.0-jdk AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -no-daemon

FROM amazoncorretto:17-alpine-jdk

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/mimimimetr-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
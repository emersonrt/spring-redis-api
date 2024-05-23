# Cria o container de build
FROM gradle:jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

# Cria o container final
FROM openjdk:17
WORKDIR /usr/src/spring-redis-api
COPY --from=build /home/gradle/src/build/libs/*.jar ./spring-redis-api.jar
CMD ["java", "-jar", "-Dlogging.level.root=DEBUG", "-Dlogging.level.org.springframework=DEBUG", "spring-redis-api.jar"]
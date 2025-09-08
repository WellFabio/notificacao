FROM gradle:7.6-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle --no-daemon

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/notificacao.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/notificacao.jar"]
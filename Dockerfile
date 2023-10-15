FROM ubuntu:latest AS build

RUN apt-get update  # Corrigido para "update"
RUN apt-get install openjdk-17-jdk -y

# O restante do Dockerfile permanece inalterado
COPY . .
RUN apt-get install maven -y
COPY . .
RUN mvn clean install

RUN apt-get clean

FROM openjdk:17-jdk-slim
EXPOSE 8080

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

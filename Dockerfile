FROM adoptopenjdk/openjdk11:latest
RUN mkdir /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
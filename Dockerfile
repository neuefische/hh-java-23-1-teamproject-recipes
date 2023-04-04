FROM openjdk:19

ENV ENVIRONMENT=prod

LABEL maintainer="team@neuefische.de"

ADD backend/target/app.jar app.jar

CMD [ "sh", "-c", "java -jar /app.jar" ]

EXPOSE 8080
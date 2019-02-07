FROM gradle:5.1.1-jdk8-alpine as BUILDER

USER root

ENV APP_HOME=/refund

WORKDIR $APP_HOME

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY . .

RUN cp src/main/resources/application.properties.template src/main/resources/application.properties

ARG mysql_user
ARG mysql_pass
ARG mysql_url

ENV MYSQL_USER=${mysql_user}
ENV MYSQL_PASS=${mysql_pass}
ENV MYSQL_URL=${mysql_url}

RUN gradle flywayMigrate -i

RUN gradle build

FROM openjdk:8-jre-alpine

ENV ARTIFACT=refund-backend.jar
ENV APP_HOME=/refund 

RUN mkdir ${APP_HOME}

WORKDIR ${APP_HOME}

COPY --from=BUILDER ${APP_HOME}/build/libs/${ARTIFACT} .

VOLUME [ "${APP_HOME}/application.properties" ]

ENTRYPOINT [ "java", "-jar", "refund-backend.jar", "--spring.config.location=/refund/application.properties"]
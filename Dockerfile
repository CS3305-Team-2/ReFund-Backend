FROM openjdk:8-jdk-alpine as BUILDER

ENV APP_HOME=/refund

WORKDIR $APP_HOME

COPY build.gradle settings.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle

COPY . .

RUN ./gradlew build

FROM openjdk:8-jre-alpine

ENV ARTIFACT=refund-backend.jar
ENV APP_HOME=/refund 

RUN mkdir ${APP_HOME}

WORKDIR ${APP_HOME}

COPY --from=BUILDER ${APP_HOME}/build/libs/${ARTIFACT} .

VOLUME [ "${APP_HOME}/application.properties" ]

ENTRYPOINT [ "java", "-jar", "${ARTIFACT}", "--spring.config.location=${APP_HOME}/application.properties"]
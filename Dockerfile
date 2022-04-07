FROM adoptopenjdk:11-jre-hotspot
LABEL maintainer="dev lecce"
LABEL version="0.0.1"
LABEL description="user rest api"
RUN apt update && apt install tzdata -y
ENV TZ="Europe/Rome"
RUN mkdir -p /opt/user/backend
COPY ../target/primorest-0.0.1-SNAPSHOT.jar /opt/user/backend
WORKDIR /opt/user/backend
ENTRYPOINT ["java", "-jar","primorest-0.0.1-SNAPSHOT.jar"]
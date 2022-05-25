FROM maven:3-openjdk-8 as build
RUN mkdir app
COPY . /app
WORKDIR /app
RUN mvn clean package


FROM nginx
RUN mkdir -p /app/game/pubg/
EXPOSE 80
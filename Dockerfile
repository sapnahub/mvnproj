FROM maven:3-openjdk-8 as build
RUN mkdir app
COPY . /app
WORKDIR /app
RUN mvn clean package


FROM tomcat
RUN mkdir -p /usr/app/
COPY --from=build /usr/app/target/*.war /usr/app/app.war
EXPOSE 8080
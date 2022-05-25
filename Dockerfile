FROM maven:3-openjdk-8 as build
RUN mkdir app
COPY . /app
WORKDIR /app
RUN mvn clean package


FROM tomcat
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
CMD ["systemctl", "start", "tomcat"]
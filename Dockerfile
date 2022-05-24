FROM maven as build
RUN mkdir app
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM tomcat
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
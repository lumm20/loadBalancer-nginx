FROM eclipse-temurin:21-jdk 
COPY target/*.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
EXPOSE 8000
ENTRYPOINT ["java","-jar","app.jar"]
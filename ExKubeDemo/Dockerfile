From openjdk:21-slim
WORKDIR /app
COPY target/ExKubeDemo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","app.jar"]
#Open JDK for Container image
From openjdk:21-slim

#Set the intermediate directory
WORKDIR /app

#Copy the source code and dependencies
COPY target/ExContainerDemo-0.0.1-SNAPSHOT.jar app.jar

#Expose the port number
EXPOSE 8081

#Run the jar
ENTRYPOINT ["java","-jar","app.jar"]

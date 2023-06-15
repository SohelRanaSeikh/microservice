FROM openjdk:17
#EXPOSE 5155
CMD mvn clean install
ADD target/mongodbdemoproject.jar mongodbdemoproject.jar
ENTRYPOINT ["java","-jar","/mongodbdemoproject.jar"]
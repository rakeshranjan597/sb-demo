FROM openjdk:8
EXPOSE 8080
ADD target/demo-sb-docker.jar demo-sb-docker.jar
ENTRYPOINT ["java","-jar","/demo-sb-docker.jar"]
MAINTAINER rakesh ranjan <rakeshranjan597@gmail.com>
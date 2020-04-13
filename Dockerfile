##Image for http server

#FROM ubuntu:16.04
FROM centos:7
MAINTAINER sivankumar86@gmail.com

RUN yum install -y  java-1.8.0-openjdk-devel

ENV PATH="/opt/program:${PATH}"

EXPOSE 80

# Set up the program in the image
COPY build/libs/awsapplication.war /opt/program/
WORKDIR /opt/program
CMD java -jar awsapplication.war


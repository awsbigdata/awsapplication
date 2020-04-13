#!/bin/bash

cd ../
gradle clean build


sudo yum install java-1.8.0-openjdk-devel
wget https://services.gradle.org/distributions/gradle-6.3-bin.zip
unzip gradle-6.3-bin.zip
export PATH=$PATH:/home/ec2-user/gradle-6.3/bin
docker run -t -i -p 80:80 awswebapp

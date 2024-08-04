FROM openjdk:11

EXPOSE 7070

ADD target/carana-virus.jar carana-virus.jar

COPY data  /data

ENTRYPOINT ["java","-jar","/carana-virus.jar"]

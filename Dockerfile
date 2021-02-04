FROM java:8
EXPOSE 8081
ADD target/springboothelloworld.jar springboothelloworld.jar
ENTRYPOINT ["java", "-jar", "/springboothelloworld.jar"]
FROM java:8
EXPOSE 8080
ADD target/SpringBootHelloWorld-0.0.1-SNAPSHOT.jar SpringBootHelloWorld-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "SpringBootHelloWorld-0.0.1-SNAPSHOT.jar"]
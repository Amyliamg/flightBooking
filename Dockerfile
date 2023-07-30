FROM openjdk
VOLUME /tmp
EXPOSE 8081
ADD target/flight-0.0.1-SNAPSHOT.jar flight-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "flight-0.0.1-SNAPSHOT.jar"]
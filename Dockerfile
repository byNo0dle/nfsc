FROM openjdk:11
VOLUME /tmp
EXPOSE 9003
ADD ./target/nfsc-0.0.1-SNAPSHOT.jar retoCP2024.jar
ENTRYPOINT ["java", "-jar", "/retoCP2024.jar"]
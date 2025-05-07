FROM amazoncorretto:17-alpine-jdk

COPY target/ARQUIWEB-0.0.1-SNAPSHOT.jar /ARQUIWEB-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/ARQUIWEB-0.0.1-SNAPSHOT.jar"]
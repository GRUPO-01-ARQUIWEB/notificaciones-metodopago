FROM amazoncorretto:17-alpine-jdk

COPY target/ARQUIWEB-0.0.1-SNAPSHOT.jar /ARQUIWEB-v1.jar

ENTRYPOINT ["java", "-jar", "/ARQUIWEB-v1.jar"]
FROM openjdk:17
COPY target/*.jar spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]
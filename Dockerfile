FROM openjdk:11
COPY target/*.jar spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]
FROM openjdk:17-alpine
EXPOSE 8080
COPY target/spring-productapi.jar spring-productrest.jar
ENTRYPOINT [ "java","-jar","spring-productrest.jar" ]
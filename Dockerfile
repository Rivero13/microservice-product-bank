FROM openjdk:11
VOLUME /tmp
ADD ./target/microservice-product-bank-0.0.1-SNAPSHOT.jar microservice-product-bank.jar
ENTRYPOINT ["java", "-jar", "/microservice-product-bank.jar"]
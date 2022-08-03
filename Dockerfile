FROM  openjdk:11.0-oracle
COPY "./target/transactionrecord-0.0.1-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java", "-jar", "app.jar"]
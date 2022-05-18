FROM openjdk:11

ADD ./target/issues*.jar /app/issues-api-service.jar
ENV JAVA_OPTIONS "-XX:MaxRAMPercentage=60.0"
ENV JAVA_JMX ""
ENV JAVA_ARGS ""
CMD ["/bin/bash", "-c", "java -server $JAVA_OPTIONS $JAVA_JMX -jar /app/issues-api-service.jar $JAVA_ARGS"]

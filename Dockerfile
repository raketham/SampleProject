FROM eclipse-temurin:17-jdk-alpine
WORKDIR /home/app
COPY SampleProject-0.0.1-*.jar .
COPY entry_point.sh .
ENTRYPOINT ["/home/app/entry_point.sh"]
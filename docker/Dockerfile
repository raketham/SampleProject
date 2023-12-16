FROM registry.access.redhat.com/ubi8/openjdk-17:1.15-1.1682053058
WORKDIR /home/app
COPY ../target/SampleProject-0.0.1-*.jar .
COPY entry_point.sh .
ENTRYPOINT ["/home/app/entry_point.sh"]
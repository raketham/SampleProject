FROM registry.access.redhat.com/ubi8/openjdk-17:1.15-1.1682053058

# Build dependency offline to streamline build
RUN mkdir project
WORKDIR /home/jboss/project
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
COPY entry_point.sh .

RUN mvn package -Dmaven.test.skip=true
# compute the created jar name and put it in a known location to copy to the next layer.
# If the user changes pom.xml to have a different version, or artifactId, this will find the jar

ENTRYPOINT ["/home/jboss/project/entry_point.sh"]
echo "application files"

ls -lart

JAR_FILE = $(ls /home/jboss/project/target/SampleProject-0.0.1-*.jar)

echo "Jar file $JAR_FILE"
java -version

java -jar $JAR_FILE


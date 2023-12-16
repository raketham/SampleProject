echo "application files"

ls -lart

JAR_FILE = $(ls SampleProject-0.0.1-*.jar)

echo "Jar file $JAR_FILE"
java -version

java -jar $JAR_FILE


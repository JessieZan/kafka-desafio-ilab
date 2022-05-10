export KAFKA_HOST="localhost:9092"
export KAFKA_TOPIC="topico_grupo3"
export KAFKA_GROUP_ID_READER="consumer_3"

export CLASSPATH=target/kafka_consumer-1.0-SNAPSHOT.jar
export className=ServerApplication
echo "## Running $className..."
shift
mvn exec:java -Dexec.mainClass="com.kafka.server;.$className"
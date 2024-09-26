### Windows based KAFKA Producer -consumer Flow

1. ##### Start Zookeeper:
   C:\Kafka\kafka_2.12-3.8.0>.\bin\windows\zookeeper-server-start .\config\zookeeper.properties
   Default Port: 2181
2. ##### Start Kafka Server/ Broker:
   C:\Kafka\kafka_2.12-3.8.0>.\bin\windows\kafka-server-start.bat .\config\server.properties
   Default port: 9092
3. ##### Comman to manipulate a Topic:
   ###### Create :-
   - Windows	-	C:\Kafka\kafka_2.12-3.8.0> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic customer-topic --partitions 3 --replication-factor 1
   - Linux	-	kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart
   ###### List :-
   C:\Kafka\kafka_2.12-3.8.0> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
   Describe :-
   .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic items-topic

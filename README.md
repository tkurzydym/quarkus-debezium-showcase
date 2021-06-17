Quarkus debezium showcase
====
This project contains two different approaches of the transaction outbox pattern based on debezium.

todo-service-standalone
----
This example handles the outbox manually and uses a custom Kafka connect transformer to send the
actual messages.

todo-service-extension
----
This uses the debezium quarkus extension to deal with the outbox and then relies on a message
based on debezium.

Prerequisites
----
In order to run this examples following steps are required:

1. Build the docker container in **debezium-transformer-standalone** via `make build`
2. Build the docker container in **debezium-transformer-extension** via `make build`

How to run this example?
----
This can be done either for **standalone** or **extension**:

1. Run the specific docker-compose file via `make docker-standalone`
2. Run the specific quarkus application via `make quarkus-standalone`
3. Create a kafka connector via `make connector-standalone-create`
4. Start the kafka listener via `make listen-cat`
5. Send a todo to the REST endpoint via `make todo`
6. Check the output of *kafkacat*

Other commands
----
- Check status of the kafka connector via `make connector-standalone-status`
- Check status of all connectors via `make connector-status`  
- List all connectors via `make connector-list`
- Delete specific connector via `make connector-standalone-delete`  
- Delete all connectors via `make connector-delete`
- Open psql session do the database via `make psql`

Tools
----
Following tools are required for the examples:

- make
- docker
- curl
- kafkacat
- psql

Links
----
https://debezium.io/documentation/reference/integrations/outbox.html
https://debezium.io/blog/2020/01/22/outbox-quarkus-extension/
https://debezium.io/documentation/reference/0.9/connectors/postgresql.html
https://docs.confluent.io/platform/current/connect/references/restapi.html
https://hub.docker.com/r/debezium/connect
https://github.com/debezium/debezium-examples/tree/master/outbox
https://github.com/debezium/debezium-examples/blob/master/outbox/debezium-strimzi/Dockerfile


Changes
---

Build the docker image "connect-tracing" with 

`cd docker/debezium-connect-tracing && docker build -t connect-tracing . && cd .. && cd ..`

After starting the docker-compose-extension.yml and your apicurio is running under 
http://localhost:8181 execute `cd todo-service-extension && mvn clean package -Dgit=true`

The Schema should be uploaded to apicurio.
Afterwards you can create the connector and start the Application and make a todo normally.

You should end up with the NPE in the debezium connect.

If changing to this configuration in the docker compose:

      KEY_CONVERTER: org.apache.kafka.connect.json.JsonConverter
      VALUE_CONVERTER: org.apache.kafka.connect.json.JsonConverter
      VALUE_CONVERTER_SERIALIZER_TYPE: json
      VALUE_CONVERTER_AVRO_APICURIO_REGISTRY_URL: http://apicurio:8181
      VALUE_CONVERTER_DATA_SERIALIZER_TYPE: json

the event is written in avro binary format to the kafka event.

What I don't understand is, that I can't detect any call from debezium to apicurio. 
(but maybe that even isn't necessary at all)
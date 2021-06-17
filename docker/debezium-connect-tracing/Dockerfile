FROM debezium/connect
ENV DEBEZIUM_DIR=$KAFKA_CONNECT_PLUGINS_DIR/debezium-connector-postgres

RUN cd $DEBEZIUM_DIR &&\
    curl -sfSL https://repo1.maven.org/maven2/io/opentracing/opentracing-api/0.33.0/opentracing-api-0.33.0.jar --output opentracing-api-0.33.0.jar &&\
    curl -sfSL https://repo1.maven.org/maven2/io/opentracing/opentracing-util/0.33.0/opentracing-util-0.33.0.jar --output opentracing-util-0.33.0.jar &&\
    curl -sfSL https://repo1.maven.org/maven2/io/opentracing/opentracing-noop/0.33.0/opentracing-noop-0.33.0.jar --output opentracing-noop-0.33.0.jar
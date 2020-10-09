package consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "broker1:9092");
        properties.put("group.id", "CountryCounter");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList("customerCountries"));

        try {
            while (true) {
                Duration duration = Duration.ofMinutes(1);
                ConsumerRecords<String, String> records = consumer.poll(duration);
            }
        } finally {
            consumer.close();
        }

    }

}

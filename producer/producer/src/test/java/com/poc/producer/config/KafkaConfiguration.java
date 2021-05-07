/**
 * 
 */
package com.poc.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.poc.producer.model.Car;



/**
 * @author sandhya.devendrappa
 *
 */
@Configuration
public class KafkaConfiguration {
	
	@Bean
    ProducerFactory<String, Car> producerFactory() {
        Map<String, Object> config = new HashMap();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9091");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, Car>(config);
    }
	
	
	 @Bean
	    KafkaTemplate<String, Car> kafkaTemplate() {
	        return new KafkaTemplate<String, Car>(producerFactory());
	    }

}

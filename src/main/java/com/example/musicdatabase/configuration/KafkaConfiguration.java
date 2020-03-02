package com.example.musicdatabase.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@ConfigurationProperties("kafka")
@EnableScheduling

@EnableKafka
public class KafkaConfiguration<T> {

	 private String serverUrl;

	  /**
	   * @return serverUrl
	   */
	  public String getServerUrl() {

	    return this.serverUrl;
	  }

	  /**
	   * @param serverUrl new value of {@link #getserverUrl}.
	   */
	  public void setServerUrl(String serverUrl) {

	    this.serverUrl = serverUrl;
	  }

	  @Bean
	  public ProducerFactory<String, List<T>> producerFactory() {

	    Map<String, Object> config = new HashMap<>();

	    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	    return new DefaultKafkaProducerFactory(config);

	  }

	  @Bean
	  public KafkaTemplate<String, List<T>> kafkaTemplate() {

	    return new KafkaTemplate<>(producerFactory());

	  }

}

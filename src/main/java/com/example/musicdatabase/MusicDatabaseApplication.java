package com.example.musicdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication//(exclude = KafkaAutoConfiguration.class)
public class MusicDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicDatabaseApplication.class, args);
	}

}

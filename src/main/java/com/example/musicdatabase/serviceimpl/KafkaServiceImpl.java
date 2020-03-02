package com.example.musicdatabase.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.repository.ArtistRepository;
import com.example.musicdatabase.service.KafkaService;

@Service
public class KafkaServiceImpl<T> implements KafkaService {

	// private static final Logger LOG = (Logger) LoggerFactory.logger(KafkaServiceImpl.class);

	 @Autowired
	    private KafkaTemplate<String, List<T>> kafkaTemplate;
	  @Autowired
	  ArtistRepository artistRepo;
	  @Autowired
	  ArtistServiceImpl artistImpl;

	  private String TOPIC = "test";


	  @Scheduled(cron = "0/20 * * * * ?")
	  public String postToKafka() {

List<T> artists = (List<T>) this.artistRepo.findAll().stream().map(a ->artistImpl.convertToDto(a)).collect(Collectors.toList());

sendMessage(artists);

return "Successfully Published";
	  }

	  public void sendMessage(List<T> message) {

		    ListenableFuture<SendResult<String,List<T>>> future = this.kafkaTemplate.send(this.TOPIC, message);

		    future.addCallback(new ListenableFutureCallback<SendResult<String, List<T>>>() {

		      @Override
		      public void onFailure(Throwable ex) {

		        System.out.println("Unable to send message=[" + message.toString() + "] due to : " + ex.getMessage());
		        System.out.println("Unable to send message due to : " + ex.getMessage());
		      }

		      @Override
		      public void onSuccess(SendResult<String,List<T>> result) {

		    	  System.out.println("Sent message=[" + message.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");

		      }


		    });
		  }

}

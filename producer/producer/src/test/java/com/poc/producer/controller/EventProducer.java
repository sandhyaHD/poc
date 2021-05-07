package com.poc.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.poc.producer.model.Car;

@RestController


public class EventProducer {

	 @Autowired
	 private KafkaTemplate<String, Car> kafkaTemplate;
	
	
	private static final String TOPIC="CarTopic";
	/*
	 * 
	 * kafka event publisher
	 */
	@PostMapping
	@RequestMapping("publish")
	@CrossOrigin
	public void carEventProducer(@RequestBody Car car) {
		
		
		 
		 try {
		        while (true) {
		        	 kafkaTemplate.send(TOPIC,car);
		        	 System.out.println("published");
		        	 Thread.sleep(1000 * 60 * 2);
		        }
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		
	}
	
	

}

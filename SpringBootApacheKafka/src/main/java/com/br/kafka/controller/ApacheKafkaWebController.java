package com.br.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.kafka.service.KafkaSender;

@RestController
@RequestMapping(value = "/hotel-kafka/")
/**
 * 
 * http://localhost:8080/hotel-kafka/producer?message=test
 * 
 * @author edson
 *
 */
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic hotel_test_hi Successfully";
	}

}


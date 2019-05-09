package com.br.spring.reactive.controller;

import java.time.Duration;
import java.time.Instant;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import reactor.core.publisher.Flux;

@RestController
public class GreetReactiveController {

	@GetMapping("/greetings")
	public Publisher<Greeting> greetingPublisher() {
		
		Faker faker = new Faker();

    	String firstName = faker.name().firstName();

    	String streetAddress = faker.address().streetAddress();
		
		Flux<Greeting> greetingFlux = Flux.<Greeting>generate(sink -> sink.next(new Greeting("HOTEL " +firstName+ " ENDEREÇO " +streetAddress))).take(50);
		return greetingFlux;
	}

	@GetMapping(value = "/greetings/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Publisher<Greeting> sseGreetings() {
		
		Faker faker = new Faker();

    	String firstName = faker.name().firstName();

    	String streetAddress = faker.address().streetAddress();
		
		Flux<Greeting> delayElements = Flux
				.<Greeting>generate(sink -> sink.next(new Greeting("HOTEL " +firstName+ " ENDEREÇO " +streetAddress + Instant.now().toString())))
				.delayElements(Duration.ofSeconds(0));
		return delayElements;
	}

}

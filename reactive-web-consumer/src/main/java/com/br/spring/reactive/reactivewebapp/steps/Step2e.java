package com.br.spring.reactive.reactivewebapp.steps;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.br.spring.reactive.reactivewebapp.Hobby;
import com.br.spring.reactive.reactivewebapp.Hotel;

import reactor.core.publisher.Flux;

public class Step2e {

	private static final Logger logger = LoggerFactory.getLogger(Step2e.class);

	private static WebClient client = WebClient.create("http://localhost:8080?delay=2");

	public static void main(String[] args) {

		Instant start = Instant.now();

		Flux.range(1, 3)
				.flatMap(i -> client.get().uri("/hotel/{id}", i).retrieve().bodyToMono(Hotel.class).flatMap(
						hotel -> client.get().uri("/hotel/{id}/hobby", i).retrieve().bodyToMono(Hobby.class)))
				.blockLast();

		logTime(start);
	}

	private static void logTime(Instant start) {
		logger.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
	}

}

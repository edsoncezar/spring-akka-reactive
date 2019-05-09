package com.br.spring.reactive.reactivewebapp.steps;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.br.spring.reactive.reactivewebapp.Hotel;

import reactor.core.publisher.Mono;

public class Step2b {

	private static final Logger logger = LoggerFactory.getLogger(Step2b.class);

	private static WebClient client = WebClient.create("http://localhost:8080");

	public static void main(String[] args) {

		Instant start = Instant.now();

		List<Mono<Hotel>> list = Stream.of(1, 2, 3, 4, 5)
				.map(i -> client.get().uri("/hotel/{id}", i).retrieve().bodyToMono(Hotel.class))
				.collect(Collectors.toList());

		Mono.when(list).block();

		logTime(start);
	}

	private static void logTime(Instant start) {
		logger.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
	}

}
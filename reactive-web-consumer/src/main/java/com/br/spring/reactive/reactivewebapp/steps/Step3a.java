package com.br.spring.reactive.reactivewebapp.steps;

import org.springframework.web.reactive.function.client.WebClient;

import com.br.spring.reactive.reactivewebapp.Hotel;

public class Step3a {

	private static WebClient client = WebClient.create("http://localhost:8080");

	public static void main(String[] args) {

		client.get().uri("/hotels/events").retrieve().bodyToFlux(Hotel.class).take(4L).blockFirst();
	}

}

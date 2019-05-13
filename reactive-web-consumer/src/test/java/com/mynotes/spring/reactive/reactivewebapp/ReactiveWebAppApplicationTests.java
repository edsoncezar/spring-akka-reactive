package com.mynotes.spring.reactive.reactivewebapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.spring.reactive.reactivewebapp.calls.CallHotelUsingRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CallHotelUsingRestTemplate.class)
public class ReactiveWebAppApplicationTests {

	@Test
	public void contextLoads() {
		
		CallHotelUsingRestTemplate.main(null);
		
	}

}

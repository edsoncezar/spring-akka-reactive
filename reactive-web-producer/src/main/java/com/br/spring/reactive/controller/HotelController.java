package com.br.spring.reactive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

@RestController
public class HotelController {

	private List<Hotel> hotelList = populateHotelList();

	@GetMapping("/hotel/{id}")
	public Hotel getHotel(@PathVariable int id, @RequestParam(defaultValue = "2") int delay)
			throws InterruptedException {
		//Thread.sleep(delay * 1000);
		return hotelList.stream().filter((hotel) -> hotel.getId() == id).findFirst().get();
	}
	
	public List<Hotel> populateHotelList() {
    	
    	hotelList = new ArrayList<>();
    	
    	Faker faker = new Faker();

    	String firstName = faker.name().firstName();

    	String streetAddress = faker.address().streetAddress();
    	
    	for (int i = 0; i < 200000; i++) {
    	
    		hotelList.add(new Hotel(i, "HOTEL " +firstName+ " ENDEREÇO " +streetAddress));
        
    	}
    	
    	return hotelList;
    	
    }

}

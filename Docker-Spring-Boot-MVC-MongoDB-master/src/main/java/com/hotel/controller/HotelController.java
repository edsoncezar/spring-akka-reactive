package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.persistence.HotelRepository;

@Component
@ConfigurationProperties
@RestController
public class HotelController {


	@Value("${application.message}")
	String message;

	@Value("${application.appname}")
	String appname;

	@Autowired
	private HotelRepository hotelRepository;

	@RequestMapping("/")
	String home() {
		return "Hello World!- " + message + " " + appname;
	}

	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public Hotel create(@RequestBody Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{hotelId}")
	public Hotel get(@PathVariable String hotelId) {
		return hotelRepository.findOne(hotelId);
	}
}

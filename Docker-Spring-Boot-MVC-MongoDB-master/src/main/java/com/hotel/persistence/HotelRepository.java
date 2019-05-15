package com.hotel.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}

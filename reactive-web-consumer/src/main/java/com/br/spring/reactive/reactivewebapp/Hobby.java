package com.br.spring.reactive.reactivewebapp;

public class Hobby {

	private int hotelId;

	private String hobby;

	public Hobby() {

	}

	public Hobby(int hotelId, String hobby) {
		super();
		this.hotelId = hotelId;
		this.hobby = hobby;
	}

	public int getHotelId() {
		return hotelId;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}

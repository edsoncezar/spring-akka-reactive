package com.br.spring.reactive.reactivewebapp;

public class Hotel {

	private int id;

	private String name;

	public Hotel() {
	}

	public Hotel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + "]";
	}

}

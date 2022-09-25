package com.cab.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {
	private int price;
	private String start_Point;
	private String end_Point;

	public Location() {
		super();
	}

	public Location(int price, String start_Point, String end_Point) {
		super();
		this.price = price;
		this.start_Point = start_Point;
		this.end_Point = end_Point;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStart_Point() {
		return start_Point;
	}

	public void setStart_Point(String start_Point) {
		this.start_Point = start_Point;
	}

	public String getEnd_Point() {
		return end_Point;
	}

	public void setEnd_Point(String end_Point) {
		this.end_Point = end_Point;
	}
}

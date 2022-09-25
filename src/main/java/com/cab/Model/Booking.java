package com.cab.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private int id;

	private int userId;

	private String pickup_location;
	private String dropof_location;
	private int date;
	private int month;
	private int year;
	private int hour;
	private int min;
	private String period;
	private String comment;
	private int price;
	private int cabId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public String getDropof_location() {
		return dropof_location;
	}
	public void setDropof_location(String dropof_location) {
		this.dropof_location = dropof_location;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public Booking(int id, int userId, String pickup_location, String dropof_location, int date, int month, int year,
			int hour, int min, String period, String comment, int price, int cabId) {
		super();
		this.id = id;
		this.userId = userId;
		this.pickup_location = pickup_location;
		this.dropof_location = dropof_location;
		this.date = date;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.min = min;
		this.period = period;
		this.comment = comment;
		this.price = price;
		this.cabId = cabId;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", pickup_location=" + pickup_location
				+ ", dropof_location=" + dropof_location + ", date=" + date + ", month=" + month + ", year=" + year
				+ ", hour=" + hour + ", min=" + min + ", period=" + period + ", comment=" + comment + ", price=" + price
				+ ", cabId=" + cabId + "]";
	}
	
}
package com.cab.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cabs {
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private int cab_Id;

	private String vehicle;
	private boolean isAvailable;
	public int getCab_Id() {
		return cab_Id;
	}
	public void setCab_Id(int cab_Id) {
		this.cab_Id = cab_Id;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Cabs(int cab_Id, String vehicle, boolean isAvailable) {
		super();
		this.cab_Id = cab_Id;
		this.vehicle = vehicle;
		this.isAvailable = isAvailable;
	}
	public Cabs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cabs [cab_Id=" + cab_Id + ", vehicle=" + vehicle + ", isAvailable=" + isAvailable + "]";
	}

	
}

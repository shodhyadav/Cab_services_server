package com.cab.Services;

import java.util.Set;

import com.cab.Model.Booking;

public interface BookingService {
public Booking createBooking(Booking booking); 
	
	public Booking updateBooking(Booking booking);
	
	public Booking getBooking(int id);
	
	public void deleteBooking(int id);
	
	public Set<Booking> getAllBooking();
	
}

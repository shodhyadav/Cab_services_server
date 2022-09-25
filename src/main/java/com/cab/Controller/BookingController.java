package com.cab.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Booking;
import com.cab.Model.User;
import com.cab.ServiceImp.BookingServiceImpl;
import com.cab.Services.SequenceGeneratorService;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl book;
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/")
	public Booking createBooking(@RequestBody Booking booking) {
		booking.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		return this.book.createBooking(booking);
	}
	
	@PutMapping("/update")
	public Booking updateBooking(@RequestBody Booking booking) {
		return this.updateBooking(booking);
	}
	
	@GetMapping("/{id}")
	public Booking getBooking(@PathVariable("id") int id) {
		return this.book.getBooking(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.book.deleteBooking(id);
	}
	
	@GetMapping("/getAllBooking")
	public Set<Booking> getAllBooking(){
		return this.book.getAllBooking();
	}

}

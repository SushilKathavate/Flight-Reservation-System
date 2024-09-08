package com.org.model;

import java.math.BigInteger;
import java.time.LocalDate; // Using LocalDate for bookingDate

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Class representing a Booking entity.
 */
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Assuming auto-generation strategy for bookingId
	private BigInteger bookingId;
	@Column(name = "booking_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "DD-MM-yyyy")
	private LocalDate bookingDate; // Changed to LocalDate for better date handling
	private int noOfPassengers;

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public ScheduledFlight getScheduleFlight() {
		// TODO Auto-generated method stub
		return null;
	}
}

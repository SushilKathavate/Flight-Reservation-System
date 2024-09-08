package com.org.model;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {

	@Id
	private BigInteger ticketId;
	private String bookingDate;
	private String journeyDate;
	private String source;
	private String destination;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	public Ticket() {}

	public Ticket(BigInteger ticketId, String bookingDate, String journeyDate, String source, String destination, List<Passenger> passengers) {
		this.ticketId = ticketId;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.source = source;
		this.destination = destination;
		this.passengers = passengers;
	}

	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}

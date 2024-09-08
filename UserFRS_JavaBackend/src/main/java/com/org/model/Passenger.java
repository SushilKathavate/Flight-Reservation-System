package com.org.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {

	@Id
	private BigInteger pnrNumber;
	private String passengerName;
	private int passengerAge;
	private BigInteger passengerUIN;
	private Double luggage;

	// No-argument constructor required by JPA
	public Passenger() {}

	// Parameterized constructor for convenience
	public Passenger(BigInteger pnrNumber, String passengerName, int passengerAge, BigInteger passengerUIN, Double luggage) {
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public Double getLuggage() {
		return luggage;
	}

	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

}

package com.org.service;

import java.math.BigInteger;

import com.org.exceptions.RecordNotFoundException;
import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.model.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public String removeScheduledFlight(Long id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ScheduledFlight viewScheduledFlight(Long id) throws ScheduledFlightNotFoundException;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}

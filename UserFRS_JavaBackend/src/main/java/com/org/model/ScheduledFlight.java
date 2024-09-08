package com.org.model;

import java.math.BigInteger;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ScheduledFlight {

    @Id
    @Column(name = "schedule_flight_id")
    private long scheduleFlightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "flight_id")
    private Flight flight;

    @Column(name = "available_seats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    // Default constructor
    public ScheduledFlight() {}

    // Parameterized constructor
    public ScheduledFlight(long scheduleFlightId, Flight flight, Integer availableSeats, Schedule schedule) {
        this.scheduleFlightId = scheduleFlightId;
        this.flight = flight;
        this.availableSeats = availableSeats;
        this.schedule = schedule;
    }

    // Getter and setter for ID
    public long getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(long scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    // Getter and setter for Available seats
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Getter and setter for Flight object
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // Getter and setter for Schedule object
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", flight=" + flight + ", availableSeats=" + availableSeats + ", schedule=" + schedule + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
        result = prime * result + ((flight == null) ? 0 : flight.hashCode());
        result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
        result = prime * result + Long.hashCode(scheduleFlightId);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduledFlight other = (ScheduledFlight) obj;
        if (availableSeats == null) {
            if (other.availableSeats != null)
                return false;
        } else if (!availableSeats.equals(other.availableSeats))
            return false;
        if (flight == null) {
            if (other.flight != null)
                return false;
        } else if (!flight.equals(other.flight))
            return false;
        if (schedule == null) {
            if (other.schedule != null)
                return false;
        } else if (!schedule.equals(other.schedule))
            return false;
        if (scheduleFlightId == 0) {
            if (other.scheduleFlightId != 0)
                return false;
        } else if (scheduleFlightId != other.scheduleFlightId)

            return false;
        return true;
    }

	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}

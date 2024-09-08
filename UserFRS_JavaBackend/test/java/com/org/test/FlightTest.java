package com.org.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.org.model.Flight;

public class FlightTest {

	long flightId = 1L;

    @BeforeEach
    public void initInput() {
        // Initialize any required objects here if needed
    }

    @Test
    public final void testEquals() throws NullPointerException {
        Flight f1 = new Flight();
        assertNotNull(f1);
        Flight f2 = null;
        Flight f3 = new Flight(flightId, "SpiceJet", "AUI89", 200);
        Flight f4 = new Flight(flightId, "SpiceJet", "AUI89", 200);
        assertTrue(f3.equals(f4));
        assertFalse(f3.equals(f2));
    }

    @Test
    public void testFlight() {
        Flight flight = new Flight(flightId, "AirIndia", "A1111", 200);
        assertEquals(flightId, flight.getFlightNo());
        assertEquals("AirIndia", flight.getCarrierName());
        assertEquals("A1111", flight.getFlightModel());
        assertEquals(200, flight.getSeatCapacity());
    }

    @Test
    public final void testToString() {
        Flight f1 = new Flight(flightId, "SpiceJet", "A45RT", 200);
        String result = String.format("Flight [flightNo=%s,carrierName=%s,flightModel=%s,seatCapacity=%d]",
                f1.getFlightNo(), f1.getCarrierName(), f1.getFlightModel(), f1.getSeatCapacity());
        System.out.println(result);
        System.out.println(f1.toString());
        assertEquals(result, f1.toString());
    }
}

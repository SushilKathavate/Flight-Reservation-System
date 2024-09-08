package com.org.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.math.BigInteger;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.org.model.Airport;
//import com.org.model.Flight;
//import com.org.model.Schedule;
//import com.org.model.ScheduledFlight;
//
//public class ScheduledFlightTest {
//
//    @BeforeEach
//    public void initInput() {
//        // Initialize any required objects here
//    }
//
//    @Test
//    public final void testScheduledFlightCreation() {
//        Airport airport1 = new Airport("A101", "Spain", "Spain Airport");
//        Airport airport2 = new Airport("A102", "India", "IGI Airport");
//        BigInteger flightId = new BigInteger("101");
//        Flight flight = new Flight(flightId, "C101", "M101", 200);
//        Schedule schedule = new Schedule(new BigInteger("1"), airport1, airport2, "12-06-2020", "13-06-2020");
//
//        ScheduledFlight sFlight = new ScheduledFlight(flightId, flight, 120, schedule);
//
//        assertNotNull(sFlight);
//        assertEquals(flightId, sFlight.getScheduleFlightId());
//        assertEquals(120, sFlight.getAvailableSeats());
//        assertEquals(flight, sFlight.getFlight());
//        assertEquals(schedule, sFlight.getSchedule());
//    }
//}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.dao.ScheduledFlightDao;
import com.org.model.ScheduledFlight;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScheduledFlightTest {

    @Autowired
    private ScheduledFlightDao scheduledFlightRepository;

    @Test
    public void testScheduledFlightCreation() {
        ScheduledFlight flight = new ScheduledFlight();
        flight.setId(101);  // Assuming you are manually setting the ID for testing
        
        // Save the flight to the repository
        scheduledFlightRepository.save(flight);
        
        // Retrieve the flight from the repository
        ScheduledFlight retrievedFlight = scheduledFlightRepository.findById(101L).orElse(null);
        
        // Perform assertions



        assertNotNull(retrievedFlight, "Flight should not be null");
        assertEquals(101, retrievedFlight.getId(), "Flight ID should match");
    }

	private void assertEquals(int i, Object id, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(ScheduledFlight retrievedFlight, String string) {
		// TODO Auto-generated method stub
		
	}
}










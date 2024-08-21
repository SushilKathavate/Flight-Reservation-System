package com.org.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ScheduleDao;
import com.org.dao.ScheduledFlightDao;
import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Booking;
import com.org.model.Schedule;
import com.org.model.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

    @Autowired
    ScheduledFlightDao dao;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    BookingService bookingService;

    @Override
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
        return dao.save(scheduledFlight);
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
        ScheduledFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
        Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getSchedule().getScheduleId()).get();
        updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
        updateSchedule.setSrcAirport(scheduleFlight.getSchedule().getSrcAirport());
        updateSchedule.setDstnAirport(scheduleFlight.getSchedule().getDstnAirport());
        updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
        updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
        dao.save(updateScheduleFlight);
        return updateScheduleFlight;
    }

    @Override
    public String removeScheduledFlight(Long flightId) throws RecordNotFoundException {
        if (flightId == null)
            throw new RecordNotFoundException("Enter flight Id");
        
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new RecordNotFoundException("Enter a valid Flight Id");
        
        cancelBookings(flightId); // Uncommenting and using the cancelBookings method
        dao.deleteById(flightId);
        return "Scheduled flight with ID " + flightId + " was removed successfully";
    }

    public boolean cancelBookings(Long flightId) throws RecordNotFoundException {
        Iterable<Booking> bookingList = bookingService.displayAllBooking();
        for (Booking booking : bookingList) {
            if (booking.getScheduleFlight().getScheduleFlightId()==(flightId)) {
                bookingService.deleteBooking(booking.getBookingId());
            }
        }
        return true;
    }

    @Override
    public Iterable<ScheduledFlight> viewAllScheduledFlights() {
        return dao.findAll();
    }

    @Override
    public ScheduledFlight viewScheduledFlight(Long flightId) throws ScheduledFlightNotFoundException {
        if (flightId == null)
            throw new ScheduledFlightNotFoundException("Enter flight Id");
        
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
        
        return scheduleFlight.get();
    }
}

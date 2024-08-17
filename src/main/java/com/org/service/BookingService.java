package com.org.service;

import java.math.BigInteger;
import org.springframework.http.ResponseEntity;
import com.org.model.Booking;

public interface BookingService {

    ResponseEntity<?> createBooking(Booking newBooking);

    Booking updateBooking(Booking updatedBooking);

    ResponseEntity<String> deleteBooking(BigInteger bookingId);

    Iterable<Booking> displayAllBooking();

    ResponseEntity<?> findBookingById(BigInteger bookingId);
}

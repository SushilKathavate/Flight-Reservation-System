package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.BookingDao;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public ResponseEntity<?> createBooking(Booking newBooking) {
        if (newBooking.getBookingId() != null) {
            return new ResponseEntity<>("Booking ID should not be provided for creation.", HttpStatus.BAD_REQUEST);
        }
        Booking savedBooking = bookingDao.save(newBooking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @Override
    public Booking updateBooking(Booking updatedBooking) {
        if (updatedBooking.getBookingId() == null) {
            throw new IllegalArgumentException("Booking ID must be provided for update.");
        }
        Optional<Booking> findBookingById = bookingDao.findById(updatedBooking.getBookingId());
        if (findBookingById.isPresent()) {
            return bookingDao.save(updatedBooking);
        } else {
            throw new RecordNotFoundException(
                    "Booking with Booking Id: " + updatedBooking.getBookingId() + " does not exist!!");
        }
    }

    @Override
    public ResponseEntity<String> deleteBooking(BigInteger bookingId) {
        if (bookingId == null) {
            return new ResponseEntity<>("Booking ID must not be null.", HttpStatus.BAD_REQUEST);
        }
        Optional<Booking> findBookingById = bookingDao.findById(bookingId);
        if (findBookingById.isPresent()) {
            bookingDao.deleteById(bookingId);
            return new ResponseEntity<>("Booking Deleted!!", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Booking not found for the entered BookingID");
        }
    }

    @Override
    public Iterable<Booking> displayAllBooking() {
        return bookingDao.findAll();
    }

    @Override
    public ResponseEntity<?> findBookingById(BigInteger bookingId) {
        if (bookingId == null) {
            return new ResponseEntity<>("Booking ID must not be null.", HttpStatus.BAD_REQUEST);
        }
        Optional<Booking> findById = bookingDao.findById(bookingId);
        if (findById.isPresent()) {
            return new ResponseEntity<>(findById.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No record found with ID " + bookingId);
        }
    }
}

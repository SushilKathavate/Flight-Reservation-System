package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Booking;
import com.org.service.BookingService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createBooking")
    public ResponseEntity<?> addBooking(@RequestBody Booking newBooking) {
        if (newBooking.getBookingId() != null) {
            return ResponseEntity.badRequest().body("Booking ID should not be provided for creation.");
        }
        
        ResponseEntity<?> createdBooking = bookingService.createBooking(newBooking);
        if (createdBooking == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating booking.");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }


    @GetMapping("/readAllBooking")
    public ResponseEntity<Iterable<Booking>> readAllBookings() {
        return ResponseEntity.ok(bookingService.displayAllBooking());
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<Object> modifyBooking(@RequestBody Booking updateBooking) {
        if (updateBooking.getBookingId() == null) {
            return ResponseEntity.badRequest().body("Booking ID must be provided for update.");
        }
        Booking updatedBooking = bookingService.updateBooking(updateBooking);
        if (updatedBooking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBooking);
    }

    @GetMapping("/searchBooking/{id}")
    public ResponseEntity<Object> searchBookingByID(@PathVariable("id") BigInteger bookingId) {
        if (bookingId == null) {
            return ResponseEntity.badRequest().body("Booking ID must not be null.");
        }
        Object booking = (Object) bookingService.findBookingById(bookingId);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
        if (bookingId == null) {
            return ResponseEntity.badRequest().body("Booking ID must not be null.");
        }
        try {
            bookingService.deleteBooking(bookingId);
            return ResponseEntity.ok("Booking deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting booking.");
        }
    }
}
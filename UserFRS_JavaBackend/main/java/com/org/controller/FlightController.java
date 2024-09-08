package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Flight;
import com.org.service.FlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/addFlight")
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @GetMapping("/allFlight")
    public Iterable<Flight> viewAllFlight() {
        return flightService.viewAllFlight();
    }

    @GetMapping("/viewFlight/{id}")
    public Flight viewFlight(@PathVariable("id") long flightNo) {
        return flightService.viewFlight(flightNo);
    }

    @PutMapping("/updateFlight")
    public void modifyFlight(@RequestBody Flight flight) {
        flightService.modifyFlight(flight);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public void removeFlight(@PathVariable("id") long flightNo) {
        flightService.removeFlight(flightNo);
    }
}

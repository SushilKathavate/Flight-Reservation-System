package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Airport;
import com.org.service.AirportService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/airport")
@Validated
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/viewAirport/{id}")
    public ResponseEntity<Airport> viewAirport(@PathVariable("id") String airportCode) {
        Airport airport = airportService.viewAirport(airportCode);
        return ResponseEntity.ok(airport);
    }

    @GetMapping("/allAirport")
    public ResponseEntity<Iterable<Airport>> viewAllAirport() {
        System.out.println("Reached here");

        Iterable<Airport> airports = airportService.viewAllAirport();
        return ResponseEntity.ok(airports);
    }

    @PostMapping("/addAirport")
    public ResponseEntity<String> addAirport(@RequestBody Airport airport) {
        airportService.addAirport(airport);
        return ResponseEntity.status(201).body("Airport added successfully");
    }

    @PutMapping("/updateAirport")
    public ResponseEntity<String> modifyAirport(@RequestBody @Valid Airport airport) {
        airportService.modifyAirport(airport);
        return ResponseEntity.ok("Airport updated successfully");
    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<String> removeAirport(@PathVariable("id") String airportCode) {
        airportService.removeAirport(airportCode);
        return ResponseEntity.ok("Airport removed successfully");
    }
}

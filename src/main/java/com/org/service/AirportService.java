package com.org.service;

import org.springframework.http.ResponseEntity;
import com.org.model.Airport;

public interface AirportService {
    Iterable<Airport> viewAllAirport();
    Airport viewAirport(String airportCode);
    ResponseEntity<?> addAirport(Airport airport);
    Airport modifyAirport(Airport airport);
    String removeAirport(String airportCode);
}

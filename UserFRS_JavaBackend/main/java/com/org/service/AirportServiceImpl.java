package com.org.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.AirportDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Airport;

import jakarta.transaction.Transactional;

@Service
public class AirportServiceImpl implements AirportService {

	private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    @Autowired
    AirportDao airportDao;

    @Override
    @Transactional
    public Iterable<Airport> viewAllAirport() {
        return airportDao.findAll();
    }

    @Override
    @Transactional
    public Airport viewAirport(String airportCode) {
        return airportDao.findById(airportCode)
                .orElseThrow(() -> new RecordNotFoundException("Airport with code: " + airportCode + " does not exist"));
    }

    @Override
    @Transactional
    public ResponseEntity<?> addAirport(Airport airport) {
        if (airportDao.existsById(airport.getAirportCode())) {
            throw new RecordAlreadyPresentException("Airport with code: " + airport.getAirportCode() + " already present");
        }
        airportDao.save(airport);
        return new ResponseEntity<>(airport, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public Airport modifyAirport(Airport airport) {
        if (!airportDao.existsById(airport.getAirportCode())) {
            throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " does not exist");
        }
        return airportDao.save(airport);
    }

    @Override
    @Transactional
    public String removeAirport(String airportCode) {
        if (!airportDao.existsById(airportCode)) {
            throw new RecordNotFoundException("Airport with code: " + airportCode + " does not exist");
        }
        airportDao.deleteById(airportCode);
        return "Airport removed";
    }
}

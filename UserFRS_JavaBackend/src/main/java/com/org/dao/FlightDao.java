package com.org.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Flight;

//@Repository
public interface FlightDao extends JpaRepository<Flight, Long> {

	Optional<Flight> findById(long flightNo);

    // Custom query methods can be added here if needed

}

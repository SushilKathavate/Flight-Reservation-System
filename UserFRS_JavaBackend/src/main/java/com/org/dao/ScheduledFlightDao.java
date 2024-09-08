package com.org.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.ScheduledFlight;

@Repository
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, BigInteger> {

	Optional<ScheduledFlight> findById(long l);

	void deleteById(Long flightId);

    // Custom query methods can be added here if needed

}

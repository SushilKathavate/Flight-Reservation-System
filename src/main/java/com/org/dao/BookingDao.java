package com.org.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, BigInteger> {

    // Custom query methods can be added here if needed

}

package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.model.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {

    // Custom query methods can be added here if needed

}

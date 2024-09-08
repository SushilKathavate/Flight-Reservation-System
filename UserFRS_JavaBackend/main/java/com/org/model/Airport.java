package com.org.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class representing an Airport entity.
 */
@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @Column(name = "code")
    private String airportCode;

    @Column(name = "name")
    private String airportName;

    @Column(name = "location")
    private String airportLocation;

    // Parameterized constructor
    public Airport(String airportName, String airportLocation, String airportCode) {
        this.airportName = airportName;
        this.airportLocation = airportLocation;
        this.airportCode = airportCode;
    }

    // Default constructor
    public Airport() {
    }

    // Getters and Setters
    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public String toString() {
        return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
                + ", airportCode='" + airportCode + '\'' + '}';
    }
}

package com.org.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightNo;  // Changed to long
    private String carrierName;
    private String flightModel;
    private int seatCapacity;

    public Flight() {
    }

    public Flight(long flightId, String carrierName, String flightModel, int seatCapacity) {
        this.flightNo = flightId;
        this.carrierName = carrierName;
        this.flightModel = flightModel;
        this.seatCapacity = seatCapacity;
    }

    public long getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(long flightNo) {
        this.flightNo = flightNo;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    @Override
    public String toString() {
        return "Flight [flightNo=" + flightNo + ", carrierName=" + carrierName + ", flightModel=" + flightModel
                + ", seatCapacity=" + seatCapacity + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carrierName == null) ? 0 : carrierName.hashCode());
        result = prime * result + ((flightModel == null) ? 0 : flightModel.hashCode());
        result = prime * result + Long.hashCode(flightNo);  // Handle long
        result = prime * result + seatCapacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (carrierName == null) {
            if (other.carrierName != null)
                return false;
        } else if (!carrierName.equals(other.carrierName))
            return false;
        if (flightModel == null) {
            if (other.flightModel != null)
                return false;
        } else if (!flightModel.equals(other.flightModel))
            return false;
        if (flightNo != other.flightNo)
            return false;
        if (seatCapacity != other.seatCapacity)
            return false;
        return true;
    }
}

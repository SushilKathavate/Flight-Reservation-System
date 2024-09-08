package com.org.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private long scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport srcAirport;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport dstnAirport;

	@Column(name = "departure_date")
	@JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	private String deptDateTime;

	@Column(name = "arrival_date")
	@JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	private String arrDateTime;

	// Default constructor
	public Schedule() {}

	// Parameterized constructor
	public Schedule(long scheduleId, Airport srcAirport, Airport dstnAirport, String deptDateTime, String arrDateTime) {
		this.scheduleId = scheduleId;
		this.srcAirport = srcAirport;
		this.dstnAirport = dstnAirport;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}

	// Getters and setters
	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long l) {
		this.scheduleId = l;
	}

	public Airport getSrcAirport() {
		return srcAirport;
	}

	public void setSrcAirport(Airport srcAirport) {
		this.srcAirport = srcAirport;
	}

	public Airport getDstnAirport() {
		return dstnAirport;
	}

	public void setDstnAirport(Airport dstnAirport) {
		this.dstnAirport = dstnAirport;
	}

	public String getDeptDateTime() {
		return deptDateTime;
	}

	public void setDeptDateTime(String deptDateTime) {
		this.deptDateTime = deptDateTime;
	}

	public String getArrDateTime() {
		return arrDateTime;
	}

	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", srcAirport=" + srcAirport + ", dstnAirport=" + dstnAirport + ", deptDateTime=" + deptDateTime + ", arrDateTime=" + arrDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrDateTime == null) ? 0 : arrDateTime.hashCode());
		result = prime * result + ((deptDateTime == null) ? 0 : deptDateTime.hashCode());
		result = prime * result + ((dstnAirport == null) ? 0 : dstnAirport.hashCode());
		result = prime * result + Long.hashCode(scheduleId);
		result = prime * result + ((srcAirport == null) ? 0 : srcAirport.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (arrDateTime == null) {
			if (other.arrDateTime != null)
				return false;
		} else if (!arrDateTime.equals(other.arrDateTime))
			return false;
		if (deptDateTime == null) {
			if (other.deptDateTime != null)
				return false;
		} else if (!deptDateTime.equals(other.deptDateTime))
			return false;
		if (dstnAirport == null) {
			if (other.dstnAirport != null)
				return false;
		} else if (!dstnAirport.equals(other.dstnAirport))
			return false;
		if (scheduleId == 0) {
			if (other.scheduleId != 0)
				return false;
		} else if (scheduleId != other.scheduleId)

			return false;
		if (srcAirport == null) {
			if (other.srcAirport != null)
				return false;
		} else if (!srcAirport.equals(other.srcAirport))
			return false;
		return true;
	}

}

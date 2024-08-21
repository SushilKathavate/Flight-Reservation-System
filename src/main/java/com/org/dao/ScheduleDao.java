package com.org.dao;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long> {

    // Custom query methods can be added here if needed

}

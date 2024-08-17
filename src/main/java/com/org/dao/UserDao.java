package com.org.dao;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import com.org.model.Users;

public interface UserDao extends JpaRepository<Users, BigInteger> {

	Users findByUserName(String username);

    // Custom query methods can be added here if needed

}

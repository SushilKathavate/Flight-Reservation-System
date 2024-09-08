package com.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.org.model.Users;

public interface UserDao extends JpaRepository<Users, Long> {

    // Change to match the property name in Users entity
    //Users findByName(String name);

    // If needed, you can use an Optional for better handling
    Optional<Users> findByName(String name);

	boolean existsByName(String name);
}

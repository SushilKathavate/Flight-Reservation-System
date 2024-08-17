package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.Users;

public interface UserService {

    public ResponseEntity<?> createUser(Users newUser);

    public Users updateUser(Users updatedUser);

    public String deleteUser(BigInteger userId);

    public Iterable<Users> displayAllUsers();

    public ResponseEntity<?> findUserById(BigInteger userId);

	public Iterable<Users> displayAllUser();
}

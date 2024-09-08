package com.org.service;

import com.org.model.LoginRequest;
import com.org.model.Users;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;

public interface UserService {

    void registerUser(Users newUser) throws RecordAlreadyPresentException;

    boolean loginUser(LoginRequest loginRequest) throws RecordNotFoundException;

    ResponseEntity<Iterable<Users>> displayAllUsers();

    Users updateUser(Users updatedUser) throws RecordNotFoundException;

    ResponseEntity<?> findUserById(Long userId) throws RecordNotFoundException;

    String deleteUser(Long userId) throws RecordNotFoundException;
}

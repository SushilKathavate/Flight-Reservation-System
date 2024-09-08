package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.LoginRequest;
import com.org.model.Users;
import com.org.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users newUser) throws com.org.service.RecordAlreadyPresentException {
        try {
            userService.registerUser(newUser);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (RecordAlreadyPresentException e) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isAuthenticated = userService.loginUser(loginRequest);
            if (isAuthenticated) {
                return new ResponseEntity<>("Login successful", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/readAllUsers")
    public ResponseEntity<Iterable<Users>> readAllUsers() {
        return userService.displayAllUsers();
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Users updateUser) {
        try {
            userService.updateUser(updateUser);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchUser/{id}")
    public ResponseEntity<?> searchUserByID(@PathVariable("id") Long userId) {
        try {
            return userService.findUserById(userId);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable("id") Long userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}

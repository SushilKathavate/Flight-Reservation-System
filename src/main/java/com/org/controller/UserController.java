package com.org.controller;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;
import com.org.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<String> addUser(@RequestBody Users newUser) {
        try {
            userService.createUser(newUser);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (RecordAlreadyPresentException e) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/readAllUsers")
    public Iterable<Users> readAllUsers() {
        return userService.displayAllUser();
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
    public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {
        try {
            return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable("id") BigInteger userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}

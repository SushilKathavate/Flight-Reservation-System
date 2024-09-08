package com.org.service;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.LoginRequest;
import com.org.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerUser(Users newUser) throws RecordAlreadyPresentException {
        if (userDao.existsByName(newUser.getName())) {
            throw new RecordAlreadyPresentException("Username already exists");
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userDao.save(newUser);
    }

    @Override
    public boolean loginUser(LoginRequest loginRequest) throws RecordNotFoundException {
        Users user = userDao.findByName(loginRequest.getUsername())
                .orElseThrow(() -> new RecordNotFoundException("User not found"));
        return passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
    }

    @Override
    public ResponseEntity<Iterable<Users>> displayAllUsers() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }

    @Override
    public Users updateUser(Users updatedUser) throws RecordNotFoundException {
        Optional<Users> userOptional = userDao.findById(updatedUser.getUserId());
        if (userOptional.isPresent()) {
            return userDao.save(updatedUser);
        } else {
            throw new RecordNotFoundException("User not found");
        }
    }

    @Override
    public ResponseEntity<?> findUserById(Long userId) throws RecordNotFoundException {
        Optional<Users> userOptional = userDao.findById(userId);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("User not found");
        }
    }

    @Override
    public String deleteUser(Long userId) throws RecordNotFoundException {
        Optional<Users> userOptional = userDao.findById(userId);
        if (userOptional.isPresent()) {
            userDao.deleteById(userId);
            return "User deleted successfully";
        } else {
            throw new RecordNotFoundException("User not found");
        }
    }
}

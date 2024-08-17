package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<?> createUser(Users newUser) {
        Optional<Users> findUserById = userDao.findById(newUser.getUserId());
        if (!findUserById.isPresent()) {
            userDao.save(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else {
            throw new RecordAlreadyPresentException("User with Id: " + newUser.getUserId() + " already exists!!");
        }
    }

    @Override
    public Users updateUser(Users updatedUser) {
        Optional<Users> findUserById = userDao.findById(updatedUser.getUserId());
        if (findUserById.isPresent()) {
            return userDao.save(updatedUser);
        } else {
            throw new RecordNotFoundException("User with Id: " + updatedUser.getUserId() + " does not exist!!");
        }
    }

    @Override
    public String deleteUser(BigInteger userId) {
        Optional<Users> findUserById = userDao.findById(userId);
        if (findUserById.isPresent()) {
            userDao.deleteById(userId);
            return "User deleted!!";
        } else {
            throw new RecordNotFoundException("User not found for the entered User ID");
        }
    }

    @Override
    public Iterable<Users> displayAllUsers() {
        return userDao.findAll();
    }

    @Override
    public ResponseEntity<?> findUserById(BigInteger userId) {
        Optional<Users> findById = userDao.findById(userId);
        if (findById.isPresent()) {
            return new ResponseEntity<>(findById.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No record found with ID " + userId);
        }
    }

	@Override
	public Iterable<Users> displayAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

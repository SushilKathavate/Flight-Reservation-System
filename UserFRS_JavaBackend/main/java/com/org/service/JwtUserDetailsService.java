//package com.org.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.org.dao.UserDao;
//import com.org.model.Users;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
//                new ArrayList<>());
//    }
//}

package com.nirmalya.springauthapp.service;

import com.nirmalya.springauthapp.model.User;
import com.nirmalya.springauthapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    // New user register functionality
    public boolean register(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    // Login functionality
    public Optional<User> login(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            return user;
        }
        return Optional.empty();
    }
}

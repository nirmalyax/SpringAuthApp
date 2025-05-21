package com.nirmalya.springauthapp.controller;

import com.nirmalya.springauthapp.model.User;
import com.nirmalya.springauthapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        boolean success = userService.register(user);
        if(success){
            return ResponseEntity.ok("User Registered Successfully");
        }
        else{
            return ResponseEntity.status(409).body("Email already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData){
        Optional<User> user = userService.login(loginData.get("email"), loginData.get("password"));

        if(user.isPresent()){
            return ResponseEntity.ok(Map.of(
                    "id",user.get().getId(),
                    "username",user.get().getUsername(),
                    "email", user.get().getEmail()
            ));
        }
        else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

package com.donation.controller;

import com.donation.model.user;
import com.donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")  
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //  Register new user
    @PostMapping("/register")
    public user registerUser(@RequestBody user user) {
        return userRepository.save(user);
    }

    //  Login 
    @PostMapping("/login")
    public String loginUser(@RequestBody user loginRequest) {
        user user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return "User not found!";
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return "Invalid password!";
        }

        return "Login successful as " + user.getRole();
    }

    //  Get all users 
    @GetMapping
    public Iterable<user> getAllUsers() {
        return userRepository.findAll();
    }
}

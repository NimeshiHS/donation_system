package com.donation.controller;

import com.donation.model.User;
import com.donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // allow frontend to access backend
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register user using form data
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam (required = false) String role
    ) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role); 

        userRepository.save(newUser);
         return "redirect:/";
    }

    // Login using form data
    @PostMapping("/login")
    public ResponseEntity<String> loginUser( 
            @RequestParam String email,
            @RequestParam String password
            
    ) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found!");
        }

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Invalid password!");
        }

        return ResponseEntity.ok("Login successful as " + user.getRole());
    }

    //  Get all users
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}

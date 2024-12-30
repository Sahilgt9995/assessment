package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestParam String fName,
                           @RequestParam String mName,
                           @RequestParam String lName) {
        return userService.saveUser(fName, mName, lName);
    }


    @GetMapping("/all") public List<User> getAllUsers() {
         return userService.getAllUsers();
        
        }
}

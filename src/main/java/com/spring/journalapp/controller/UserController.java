package com.spring.journalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.journalapp.entity.User;
import com.spring.journalapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    } 
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveEntry(user);
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User userInDB=userService.findByUserName(user.getUsername());
        if (userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setPassword(user.getPassword());
            userService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")  // This maps the requests to /users
public class UserController {

    @Autowired
    private PollManager pollManager;

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        pollManager.addUser(user.getUsername(), user);  // Add the user to the PollManager
        return new ResponseEntity<>(user, HttpStatus.CREATED);  // Return 201 Created with the user data
    }

    // List all users
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = pollManager.getAllUsers();  // Fetch all users from the PollManager
        return new ResponseEntity<>(users, HttpStatus.OK);  // Return 200 OK with the list of users
    }
    // Get a user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = pollManager.getUser(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user (optional, if needed)
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        pollManager.removeUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


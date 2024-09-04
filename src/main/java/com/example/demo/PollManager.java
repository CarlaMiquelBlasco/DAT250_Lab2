package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class PollManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Poll> polls = new HashMap<>();

    // Add a new user
    public void addUser(String username, User user) {
        users.put(username, user);
    }

    // Get a user by username
    public User getUser(String username) {
        return users.get(username);
    }

    // Update a user
    public void updateUser(String username, User updatedUser) {
        users.put(username, updatedUser);
    }

    // Remove a user
    public void removeUser(String username) {
        users.remove(username);
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());  // Return all users as a list
    }

    // Add a new poll
    public void addPoll(String pollId, Poll poll) {
        polls.put(pollId, poll);
    }

    // Get a poll by pollId
    public Poll getPoll(String pollId) {
        return polls.get(pollId);
    }

    // Update a poll
    public void updatePoll(String pollId, Poll updatedPoll) {
        polls.put(pollId, updatedPoll);
    }

    // Remove a poll
    public void removePoll(String pollId) {
        polls.remove(pollId);
    }
}

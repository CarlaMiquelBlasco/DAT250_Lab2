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
    private Map<String, Vote> votes = new HashMap<>();
    private int voteCounter = 1; // To generate unique vote IDs

    // User management
    public void addUser(String username, User user) {
        users.put(username, user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    // Poll management
    public void addPoll(String pollId, Poll poll) {
        polls.put(pollId, poll);
    }

    public Poll getPoll(String pollId) {
        return polls.get(pollId);
    }

    public List<Poll> getAllPolls() {
        return new ArrayList<>(polls.values());
    }

    public void removePoll(String pollId) {
        polls.remove(pollId);
    }
}

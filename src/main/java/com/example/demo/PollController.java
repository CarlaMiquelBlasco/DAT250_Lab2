package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    // Create a new poll
    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        // Set the publishedAt field to the current time
        poll.setPublishedAt(Instant.now());
        pollManager.addPoll(poll.getQuestion(), poll);
        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }

    // List all polls
    @GetMapping
    public ResponseEntity<List<Poll>> listPolls() {
        return new ResponseEntity<>(pollManager.getAllPolls(), HttpStatus.OK);
    }

    // Get a poll by ID (optional)
    @GetMapping("/{pollId}")
    public ResponseEntity<Poll> getPoll(@PathVariable String pollId) {
        Poll poll = pollManager.getPoll(pollId);
        if (poll != null) {
            return new ResponseEntity<>(poll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a poll by ID
    @DeleteMapping("/{pollId}")
    public ResponseEntity<Void> deletePoll(@PathVariable String pollId) {
        pollManager.removePoll(pollId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private PollManager pollManager;

    private List<Vote> votes = new ArrayList<>();

    @PostMapping("/{pollId}")//{username}
    public Vote castVote( @PathVariable String pollId, @RequestBody Vote vote) { //@PathVariable String username,
        // Check if the vote option already exists in the votes list
        boolean optionExists = false;

        for (Vote existingVote : votes) {
            // Check if the caption of the existing vote matches the current vote
            if (existingVote.getVoteOption().getCaption().equals(vote.getVoteOption().getCaption())) {
                // Increment upvotes for the existing vote option
                existingVote.getVoteOption().setUpvote(existingVote.getVoteOption().getUpvote() + 1);
                vote.getVoteOption().setUpvote(existingVote.getVoteOption().getUpvote() + 1);
                optionExists = true;
                break;  // No need to continue searching
            }
        }

        // If the vote option doesn't exist yet, set its upvotes to 1
        if (!optionExists) {
            vote.getVoteOption().setUpvote(1);
            votes.add(vote);
        }

        // Update the poll in PollManager with the new vote count
        Poll poll = pollManager.getPoll(pollId);  // Get the poll from PollManager
        if (poll != null) {
            for (VoteOption option : poll.getVoteOptions()) {
                if (option.getCaption().equals(vote.getVoteOption().getCaption())) {
                    option.setUpvote(vote.getVoteOption().getUpvote());  // Update the vote count in PollManager
                }
            }
        }

        pollManager.addPoll(pollId, poll);  // Update the poll in PollManager


        return vote;
    }

    @PutMapping("/{pollId}")//{username}
    public Vote changeVote( @PathVariable String pollId, @RequestBody Vote vote) {//@PathVariable String username,
        // Simulate changing the vote for the user on the poll
        votes.removeIf(v -> v.getVoteOption().equals(vote.getVoteOption())); // Remove old vote
        votes.add(vote); // Add new vote
        return vote;
    }

    @GetMapping("/{pollId}")
    public List<Vote> listVotes(@PathVariable String pollId) {
        return votes;
    }


    @DeleteMapping
    public void deleteVotes() {
        votes.clear();
    }
}
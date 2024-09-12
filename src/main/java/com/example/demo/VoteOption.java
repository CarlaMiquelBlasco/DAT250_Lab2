package com.example.demo;

public class VoteOption {
    private String caption;
    private int presentationOrder;
    private int upvote;

    // Parameterless constructor
    public VoteOption() {}

    // Getters and setters
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

    public int getUpvote() {  // Corrected to return an int
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    // Method to increment upvotes
    public void incrementUpvote() {
        this.upvote++;
    }
}

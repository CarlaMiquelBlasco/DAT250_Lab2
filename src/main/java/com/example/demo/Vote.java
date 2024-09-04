package com.example.demo;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;

    // Parameterless constructor
    public Vote() {}

    // Getters and setters
    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}


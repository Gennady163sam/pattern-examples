package com.genius.controllers.adapter;

public enum Priority {
    LOW(0), MIDDLE(1), HIGH(2);

    private int stars;

    Priority(int stars) {
        this.stars = stars;
    }
}

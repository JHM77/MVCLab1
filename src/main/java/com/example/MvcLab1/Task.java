package com.example.MvcLab1;

public class Task {

    private String description;
    private String comment;
    private String owner;
    private boolean isCompleted;

    public Task(String description, String comment, String owner, boolean isCompleted) {
        this.description = description;
        this.comment = comment;
        this.owner = owner;
        this.isCompleted = isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public String getComment() {
        return comment;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String booleanToString(boolean b) {
        return b ? "Yes" : "No";
    }
}


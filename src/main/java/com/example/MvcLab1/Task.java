package com.example.MvcLab1;

public class Task {

    private String description;
    private String comment;
    private String owner;
    private Boolean isCompleted;

    public Task() {
    }

    public Task(String description, String comment, String owner, Boolean isCompleted) {
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        isCompleted = isCompleted;
    }
}


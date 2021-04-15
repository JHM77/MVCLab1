package com.example.MvcLab1;

import javax.persistence.*;

public class Task {
    private Integer id;
    private String description;
    private String comment;
    private String owner;
    private Boolean isCompleted;

    public Task() {
    }

    public Task(Integer id, String description, String comment, String owner, Boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.comment = comment;
        this.owner = owner;
        this.isCompleted = isCompleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        isCompleted = isCompleted;
    }
}


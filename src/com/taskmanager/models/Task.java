package com.taskmanager.models;

public class Task {
    private final long id;
    private String title;
    private String description;
    private boolean isDone = false;

    public Task(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() { return id; }

    public String getTitle() { return title; }
    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String getDescription() { return description; }

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public String getStatus(){
        return isDone? "Concluída" : "Pendente";
    }
    public boolean isDone() { return isDone; }
    public void markAsDone() { isDone = true; }
    public void markIsPending(){ isDone = false; }
}
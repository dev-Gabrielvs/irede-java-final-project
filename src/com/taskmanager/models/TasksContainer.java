package com.taskmanager.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TasksContainer {
    private ArrayList<Task> tasks =  new ArrayList<>();

    public List<Task> getTasks() {
        if (this.tasks == null || this.tasks.isEmpty()) {
            return new ArrayList<Task>();
        }else {
            return this.tasks;
        }
    }
    public Optional<Task> getTaskById(long id) {
        return this.tasks.stream().filter(task -> task.getId() == id).findFirst();
    }
    public void deleteTaskById(long id) {
        this.tasks.removeIf(task -> task.getId() == id);
    }

    public void deleteAllFinishedTasks() {
        this.tasks.removeIf(task -> task.isDone());
    }

    public void setTasks(ArrayList<Task> tasks) { this.tasks = tasks; }
    public void addTask(Task task) {
        this.tasks.add(task);
    }

}

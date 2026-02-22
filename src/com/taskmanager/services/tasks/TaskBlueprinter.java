package com.taskmanager.services.tasks;

import com.taskmanager.models.Task;

public class TaskBlueprinter {
    public String format(Task task) {
        return String.format("[%d] %s - %s - %s", task.getId(), task.getStatus(), task.getTitle(), task.getDescription());
    }
}

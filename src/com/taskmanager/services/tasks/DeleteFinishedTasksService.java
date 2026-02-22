package com.taskmanager.services.tasks;

import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;

import java.util.List;

public class DeleteFinishedTasksService {
    private final TasksContainer tasksContainer;
    public DeleteFinishedTasksService(TasksContainer tasksContainer) {
        this.tasksContainer = tasksContainer;
    }

    public void execute() {
        tasksContainer.deleteAllFinishedTasks();
    }
}

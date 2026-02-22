package com.taskmanager.services.tasks;

import com.taskmanager.exceptions.InvalidTaskException;
import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;

import java.util.Optional;

public class DeleteTaskByIdService {
    private final TasksContainer tasksContainer;
    public DeleteTaskByIdService(TasksContainer tasksContainer) {
        this.tasksContainer = tasksContainer;
    }

    public Task execute(long id){
        Optional<Task> task = tasksContainer.getTaskById(id);
        Task foundTask;

        if (task.isPresent()) {
            foundTask = task.get();
            tasksContainer.deleteTaskById(foundTask.getId());
        }else {
            throw new InvalidTaskException(String.format("Nenhum task com o ID %d encontrada!", id));
        }

        return foundTask;
    }
}

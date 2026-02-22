package com.taskmanager.services.tasks;
import com.taskmanager.exceptions.InvalidTaskException;
import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;

import java.util.Optional;

public class ChangeTaskStatusService {
    private final TasksContainer tasksContainer;
    private final TaskBlueprinter taskBlueprinter = new TaskBlueprinter();
    public ChangeTaskStatusService(TasksContainer tasksContainer) { this.tasksContainer = tasksContainer; }

    public Task execute(long id) {
        Optional<Task> task = tasksContainer.getTaskById(id);
        Task foundTask;
        if (task.isPresent()) {
            foundTask = task.get();
            if (foundTask.isDone()) {
                foundTask.markIsPending();
            }else {
                foundTask.markAsDone();
            }
        }else {
            throw new InvalidTaskException(String.format("Nenhum task com o ID %d encontrada!", id));
        }
        return foundTask;
    }
}

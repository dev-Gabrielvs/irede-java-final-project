package com.taskmanager.services.tasks;
import com.taskmanager.exceptions.InvalidTaskException;
import com.taskmanager.models.Task;

public class CreateTaskService {
    public Task execute(long taskId, String taskTitle, String taskDescription) {
        if (taskTitle == null || taskTitle.isBlank()){
            throw new InvalidTaskException("O título da tarefa é obrigatório");
        }
        if (taskDescription == null || taskDescription.isBlank()){
            throw new InvalidTaskException("A descrição da tarefa é obrigatória");
        }

        return new Task(taskId, taskTitle, taskDescription);
    }
}

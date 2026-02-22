package com.taskmanager.controllers;

import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;
import com.taskmanager.services.tasks.*;
import java.util.Scanner;


public class TasksController {
    public TasksContainer tasksContainer;
    private final ListTasksService listTasksService;
    private final CreateTaskService createTaskService;
    private final ChangeTaskStatusService changeTaskStatusService;
    private final DeleteTaskByIdService deleteTaskByIdService;
    private final DeleteFinishedTasksService deleteFinishedTasksService;

    public TasksController(TasksContainer tasksContainer) {
        this.tasksContainer = tasksContainer;
        this.listTasksService = new ListTasksService(tasksContainer);
        this.createTaskService = new CreateTaskService();
        this.changeTaskStatusService = new ChangeTaskStatusService(tasksContainer);
        this.deleteTaskByIdService = new DeleteTaskByIdService(tasksContainer);
        this.deleteFinishedTasksService = new DeleteFinishedTasksService(tasksContainer);
    }

    public Task newTask(Scanner scanner) {
        long taskId = tasksContainer.getTasks().size() + 1;

        String taskTitle;
        String taskDescription;
        System.out.println("Digite o nome da Tarefa: ");
        taskTitle = scanner.nextLine();
        System.out.println("Digite a descrição da Tarefa: ");
        taskDescription = scanner.nextLine();

        Task newTask = createTaskService.execute(taskId, taskTitle, taskDescription);
        tasksContainer.addTask(newTask);

        return newTask;
    }
    
    public void listTasks() {
        listTasksService.execute();
    }

    public Task changeTaskStatus(Scanner scanner) {

        System.out.println("Digite o ID da tarefa a ser alterada");
        long taskId = scanner.nextLong();
        scanner.nextLine();

        return changeTaskStatusService.execute(taskId);
    }

    public Task deleteTask(Scanner scanner) {
        System.out.println("Digite o ID da tarefa a ser deletada");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        return deleteTaskByIdService.execute(taskId);
    }

    public void deleteFinishedTasks(Scanner scanner) {
        System.out.println("""
                Tem certeza que deseja prosseguir com essa ação?
                1. Sim;
                2. Não.""");
        byte userChoose = scanner.nextByte();
        scanner.nextLine();
        if (userChoose == 1) {
            deleteFinishedTasksService.execute();
            System.out.println("Tarefas concluídas deletadas");
        }else {
            System.out.println("Os dados foram preservados");
        }
    }
}

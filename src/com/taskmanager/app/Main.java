package com.taskmanager.app;

import com.taskmanager.controllers.TasksController;
import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;
import com.taskmanager.services.tasks.TaskBlueprinter;
import java.util.Scanner;

public class Main {
    private static void freezeTerminal(Scanner scanner) {
        System.out.println("Aperte enter para continuar");
        scanner.nextLine();
    }

    private static byte readMenuChoice(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Byte.parseByte(input);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número de 1 a 6.");
            }
        }
    }

    public static void main(String[] args) {
        final TasksContainer tasksContainer = new TasksContainer();
        final TasksController tasksController = new TasksController(tasksContainer);
        final TaskBlueprinter taskBlueprinter = new TaskBlueprinter();
        Task task;

        Scanner scanner = new Scanner(System.in);
        byte userChoose;

        do {
            System.out.println("""
                    Bem-vindo ao Task Manager
                    -------------------------------------
                    Selecione uma das opções abaixo para prosseguir:
                    1. Ver tarefas;
                    2. Adicionar Tarefas;
                    3. Alterar status da tarefa;
                    4. Remover tarefa;
                    5. Remover tarefas concluídas;
                    6. Sair.""");
            userChoose =  readMenuChoice(scanner);
            switch (userChoose) {
                case 1:
                    tasksController.listTasks();
                    freezeTerminal(scanner);
                    break;
                case 2:
                    task = tasksController.newTask(scanner);
                    System.out.printf("Nova tarefa adicionada!%n%s%n", taskBlueprinter.format(task));
                    freezeTerminal(scanner);
                    break;
                case 3:
                    task = tasksController.changeTaskStatus(scanner);
                    System.out.printf("Status da tarefa alterado!%n%s%n", taskBlueprinter.format(task));
                    freezeTerminal(scanner);
                    break;
                case 4:
                    task = tasksController.deleteTask(scanner);
                    System.out.printf("Tarefa removida!%n%s%n", taskBlueprinter.format(task));
                    freezeTerminal(scanner);
                    break;
                case 5:
                    tasksController.deleteFinishedTasks(scanner);
                    freezeTerminal(scanner);
                    break;
            }
        }while(userChoose != 6);
    }
}

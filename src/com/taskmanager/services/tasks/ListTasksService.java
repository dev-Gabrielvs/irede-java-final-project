package com.taskmanager.services.tasks;

import com.taskmanager.models.Task;
import com.taskmanager.models.TasksContainer;

import java.util.List;


public class ListTasksService {
   final TasksContainer tasksContainer;
   final TaskBlueprinter taskBlueprinter = new  TaskBlueprinter();
   public ListTasksService(TasksContainer tasksContainer) {
       this.tasksContainer = tasksContainer;
   }

   public void execute() {
       List<Task> tasks = this.tasksContainer.getTasks();
       tasks.forEach(task -> {
           System.out.println(taskBlueprinter.format(task));;
       });
   }
}
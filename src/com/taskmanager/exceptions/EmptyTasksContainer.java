package com.taskmanager.exceptions;

public class EmptyTasksContainer extends RuntimeException {
    public EmptyTasksContainer(String message) {
        super(message);
    }
}

package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.exceptions;

public class TaskManagerCLIInputException extends RuntimeException {
    public TaskManagerCLIInputException() {
        super("Incorrect value. Please provide valid input");
    }
}

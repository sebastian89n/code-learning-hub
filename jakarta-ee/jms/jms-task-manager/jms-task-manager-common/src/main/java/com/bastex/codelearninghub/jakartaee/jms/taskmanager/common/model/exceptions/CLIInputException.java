package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.exceptions;

public class CLIInputException extends RuntimeException {
    public CLIInputException() {
        super("Incorrect value. Please provide valid input");
    }
}

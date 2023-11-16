package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("Incorrect value. Please provide valid input");
    }
}

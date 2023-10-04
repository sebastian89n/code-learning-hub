package com.bastex.codelearninghub.testing.exceptions;

public class UserValidationException extends RuntimeException {
    public UserValidationException(final String message) {
        super(message);
    }

    public UserValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

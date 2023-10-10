package com.bastex.codelearninghub.java.libs.junitwithmockito.exceptions;

public class UserValidationException extends RuntimeException {
    public UserValidationException(final String message) {
        super(message);
    }

    public UserValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

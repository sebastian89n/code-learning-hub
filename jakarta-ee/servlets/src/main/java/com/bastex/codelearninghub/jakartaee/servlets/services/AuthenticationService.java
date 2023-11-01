package com.bastex.codelearninghub.jakartaee.servlets.services;

public interface AuthenticationService {
    static AuthenticationService newInMemoryInstance(final String usersFilePath) {
        return new AuthenticationInMemoryService(usersFilePath);
    }

    boolean authenticateUser(final String username, final String password);
}

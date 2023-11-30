package com.bastex.codelearninghub.jakartaee.servlets.services;

import com.bastex.codelearninghub.jakartaee.servlets.dto.User;
import com.bastex.codelearninghub.jakartaee.servlets.utils.ResourceReader;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Map;

class AuthenticationInMemoryService implements AuthenticationService {
    private final Map<String, User> usersPerUsername;

    @SneakyThrows
    public AuthenticationInMemoryService(@NonNull final String usersResourcePath) {
        usersPerUsername = ResourceReader.readUsersFromResource(usersResourcePath);
    }

    @Override
    public boolean authenticateUser(@NonNull final String username, @NonNull final String password) {
        final User user = usersPerUsername.get(username);
        return user != null && user.password().equals(password);
    }
}

package com.bastex.codelearninghub.spring.context.scopes.services;

import com.bastex.codelearninghub.spring.context.scopes.model.User;

public interface UserService {
    void registerUser(User user);

    void logUsers();
}

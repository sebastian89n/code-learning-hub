package com.bastex.codelearninghub.spring.context.scopes.services;

import com.bastex.codelearninghub.spring.context.scopes.model.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // default scope, optional annotation
public class UserServiceImpl implements UserService {
    private final Set<User> users = new LinkedHashSet<>();

    @Override
    public void registerUser(@NonNull final User user) {
        users.add(user);
    }

    @Override
    public void logUsers() {
        log.info("Logging all users...");
        users.forEach(user -> log.info("{}", user));
    }
}

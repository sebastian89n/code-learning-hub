package com.bastex.codelearninghub.java.libs.junitwithmockito;

import com.bastex.codelearninghub.java.libs.junitwithmockito.domain.User;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.AuditService;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.UserService;
import com.bastex.codelearninghub.java.libs.junitwithmockito.utils.UserValidationUtils;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;

    private final AuditService auditService;

    public User addNewUser(final User user) {
        UserValidationUtils.validateNewUser(user);

        final User savedUser = userService.save(user);
        auditService.addSaveNewEntryEvent(savedUser.getId());
        return savedUser;
    }

    public User upsert(final User user) {
        UserValidationUtils.validateUser(user);

        final User savedUser = userService.save(user);

        if (user.getId() == null) {
            auditService.addSaveNewEntryEvent(savedUser.getId());
        } else {
            auditService.addUpdateNewEntryEvent(savedUser.getId());
        }

        return savedUser;
    }

    public boolean deleteUserById(final long userId) {
        final boolean deleted = userService.deleteById(userId);
        if (deleted) {
            auditService.addNewDeletedEvent(userId);
        }

        return deleted;
    }

    public Optional<User> findUserById(final long userId) {
        return Optional.ofNullable(userService.findById(userId));
    }

    public Optional<String> findUserFullNameById(final long userId) {
        final User user = userService.findById(userId);
        return user != null ? Optional.of(user.getFirstName() + " " + user.getLastName()) : Optional.empty();
    }

    public boolean exists(final long userId) {
        return userService.exists(userId);
    }
}

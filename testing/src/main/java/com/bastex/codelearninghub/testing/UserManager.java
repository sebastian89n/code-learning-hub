package com.bastex.codelearninghub.testing;

import com.bastex.codelearninghub.testing.domain.User;
import com.bastex.codelearninghub.testing.exceptions.UserValidationException;
import com.bastex.codelearninghub.testing.services.AuditService;
import com.bastex.codelearninghub.testing.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;

    private final AuditService auditService;

    public User addNewUser(final User user) {
        validateUser(user);

        if (user.getId() != null) {
            throw new UserValidationException("Id cannot be provided for new user");
        }

        final User savedUser = userService.save(user);

        auditService.addSaveNewEntryEvent(savedUser.getId());
        return upsert(user);
    }

    public User upsert(final User user) {
        validateUser(user);

        final User savedUser = userService.save(user);

        if (user.getId() == null) {
            auditService.addSaveNewEntryEvent(savedUser.getId());
        } else {
            auditService.addUpdateNewEntryEvent(savedUser.getId());
        }

        return savedUser;
    }

    private static void validateUser(final User user) {
        if (user == null) {
            throw new UserValidationException("User cannot be empty");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new UserValidationException("User email must be provided");
        }
    }
}

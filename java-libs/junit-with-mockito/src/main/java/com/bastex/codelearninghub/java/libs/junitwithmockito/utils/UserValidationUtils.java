package com.bastex.codelearninghub.java.libs.junitwithmockito.utils;

import com.bastex.codelearninghub.java.libs.junitwithmockito.domain.User;
import com.bastex.codelearninghub.java.libs.junitwithmockito.exceptions.UserValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserValidationUtils {
    public static void validateNewUser(final User user) {
        validateUser(user);
        
        if (user.getId() != null) {
            throw new UserValidationException("Id cannot be provided for new user");
        }
    }

    public static void validateUser(final User user) {
        if (user == null) {
            throw new UserValidationException("User cannot be empty");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new UserValidationException("User email must be provided");
        }
    }
}

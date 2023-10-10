package com.bastex.codelearninghub.java.libs.junitwithmockito.services;

import com.bastex.codelearninghub.java.libs.junitwithmockito.domain.User;
import lombok.NonNull;

import java.util.Set;

public interface UserService {
    User save(@NonNull final User user);

    User findById(final long userId);

    Set<User> findAll();

    boolean exists(final long userId);

    boolean delete(@NonNull final User user);

    boolean deleteById(final long userId);
}

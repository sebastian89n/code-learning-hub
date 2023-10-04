package com.bastex.codelearninghub.testing.services;

import com.bastex.codelearninghub.testing.domain.User;
import lombok.NonNull;

import java.util.Set;

public interface UserService {
    User save(@NonNull final User user);

    User findById(@NonNull final Long id);

    Set<User> findAll();

    boolean delete(@NonNull final User user);

    boolean deleteById(@NonNull final Long id);
}

package com.bastex.codelearninghub.testing.services;

import com.bastex.codelearninghub.testing.domain.User;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class UserInMemoryService implements UserService {
    protected final Map<Long, User> idToEntity = new HashMap<>();

    @Override
    public User save(@NonNull final User user) {
        if (user.getId() == null) {
            user.setId(getNextId());
        }

        idToEntity.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(final long id) {
        return idToEntity.get(id);
    }

    @Override
    public Set<User> findAll() {
        return new LinkedHashSet<>(idToEntity.values());
    }

    @Override
    public boolean exists(final long userId) {
        return idToEntity.containsKey(userId);
    }

    @Override
    public boolean delete(@NonNull final User user) {
        return idToEntity.entrySet().removeIf(existingEntity -> existingEntity.getValue().equals(user));
    }

    @Override
    public boolean deleteById(final long userId) {
        final User removed = idToEntity.remove(userId);
        return removed != null;
    }

    private Long getNextId() {
        return idToEntity.isEmpty() ? 1 : Collections.max(idToEntity.keySet()) + 1;
    }
}

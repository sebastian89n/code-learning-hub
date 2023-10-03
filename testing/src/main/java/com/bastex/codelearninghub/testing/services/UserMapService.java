package com.bastex.codelearninghub.testing.services;

import com.bastex.codelearninghub.testing.domain.User;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.*;

@NoArgsConstructor
public class UserMapService implements UserService {
    protected final Map<Long, User> idToEntity = new HashMap<>();

    @Override
    public User save(@NonNull final User entity) {
        if (entity.getId() == null) {
            entity.setId(getNextId());
        }

        idToEntity.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public User findById(@NonNull final Long id) {
        return idToEntity.get(id);
    }

    @Override
    public Set<User> findAll() {
        return new LinkedHashSet<>(idToEntity.values());
    }

    @Override
    public boolean delete(@NonNull final User entity) {
        return idToEntity.entrySet().removeIf(existingEntity -> existingEntity.getValue().equals(entity));
    }

    @Override
    public boolean deleteById(@NonNull final Long id) {
        final User removed = idToEntity.remove(id);
        return removed != null;
    }

    private Long getNextId() {
        return idToEntity.isEmpty() ? 1 : Collections.max(idToEntity.keySet()) + 1;
    }
}

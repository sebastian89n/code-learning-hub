package com.bastex.petclinic.services.map;

import com.bastex.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class AbstractMapService<T, ID> implements CrudService<T, ID> {
    protected final Map<ID, T> idToEntity = new HashMap<>();

    @Override
    public abstract T save(final T entity);

    @Override
    public T findById(final ID id) {
        return idToEntity.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(idToEntity.values());
    }

    @Override
    public boolean delete(final T entity) {
        return idToEntity.entrySet().removeIf(existingEntity -> existingEntity.getValue().equals(entity));
    }

    @Override
    public boolean deleteById(final ID id) {
        final T removed = idToEntity.remove(id);
        return removed != null;
    }

    protected T save(final ID id, final T entity) {
        return idToEntity.put(id, entity);
    }
}

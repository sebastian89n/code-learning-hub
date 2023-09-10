package com.bastex.petclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(final ID id);

    Set<T> findAll();

    T save(final T entity);

    boolean delete(T entity);

    boolean deleteById(ID id);
}

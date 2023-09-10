package com.bastex.petclinic.services;

import com.bastex.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Set<Owner> findByLastName(String lastName);
}

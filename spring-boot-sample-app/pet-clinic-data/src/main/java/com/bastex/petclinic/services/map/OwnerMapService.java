package com.bastex.petclinic.services.map;

import com.bastex.petclinic.model.Owner;
import com.bastex.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(final Owner entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Owner> findByLastName(final String lastName) {
        return idToEntity.values()
                .stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .collect(Collectors.toSet());
    }
}

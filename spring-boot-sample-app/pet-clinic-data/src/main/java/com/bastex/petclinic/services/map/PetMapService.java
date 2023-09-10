package com.bastex.petclinic.services.map;

import com.bastex.petclinic.model.Pet;
import com.bastex.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(final Pet entity) {
        return super.save(entity.getId(), entity);
    }
}

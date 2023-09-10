package com.bastex.codelearninghub.spring5.boot.services.profiles;

import com.bastex.codelearninghub.spring5.boot.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"default", "dog"})
@Service
public class DogService implements PetService {
    @Override
    public String sayFavouritePetType() {
        return "Dogs are the best!";
    }
}

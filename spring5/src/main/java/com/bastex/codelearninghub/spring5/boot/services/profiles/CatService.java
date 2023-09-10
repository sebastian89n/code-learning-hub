package com.bastex.codelearninghub.spring5.boot.services.profiles;

import com.bastex.codelearninghub.spring5.boot.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("cat")
@Service
public class CatService implements PetService {
    @Override
    public String sayFavouritePetType() {
        return "Cats are the best";
    }
}
package com.bastex.codelearninghub.spring.context.di.controllers.profiles;

import com.bastex.codelearninghub.spring.context.di.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Another profile exampels
 */
@Controller
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    public String sayFavouritePetType() {
        return petService.sayFavouritePetType();
    }
}

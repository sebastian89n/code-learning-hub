package com.bastex.codelearninghub.spring5.context.configuration.services;

public class DogServiceImpl implements PetService {
    @Override
    public String getFavouritePet() {
        return "dog";
    }
}

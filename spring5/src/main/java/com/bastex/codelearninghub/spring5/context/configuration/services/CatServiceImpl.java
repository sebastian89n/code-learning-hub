package com.bastex.codelearninghub.spring5.context.configuration.services;

public class CatServiceImpl implements PetService {
    @Override
    public String getFavouritePet() {
        return "cat";
    }
}

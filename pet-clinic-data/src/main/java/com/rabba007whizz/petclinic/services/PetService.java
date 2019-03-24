package com.rabba007whizz.petclinic.services;

import java.util.Set;

import com.rabba007whizz.petclinic.model.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

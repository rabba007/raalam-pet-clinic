package com.rabba007whizz.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rabba007whizz.petclinic.model.Pet;
import com.rabba007whizz.petclinic.repositories.PetRepository;
import com.rabba007whizz.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSdJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSdJpaService(PetRepository petTypeRepository) {
        super();
        this.petRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> petTypes = new HashSet<>();
        petRepository.findAll().iterator().forEachRemaining(petTypes::add);
        return petTypes;
    }

    @Override
    public Pet findById(Long id) {

        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {

        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);

    }

}

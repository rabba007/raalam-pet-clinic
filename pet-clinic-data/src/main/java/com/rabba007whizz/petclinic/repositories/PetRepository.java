package com.rabba007whizz.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabba007whizz.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}

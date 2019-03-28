package com.rabba007whizz.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabba007whizz.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}

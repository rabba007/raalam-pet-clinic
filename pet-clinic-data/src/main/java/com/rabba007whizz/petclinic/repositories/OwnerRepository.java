package com.rabba007whizz.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabba007whizz.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}

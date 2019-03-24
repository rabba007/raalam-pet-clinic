package com.rabba007whizz.petclinic.services;

import java.util.Set;

import com.rabba007whizz.petclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}

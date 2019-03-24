package com.rabba007whizz.petclinic.services;

import java.util.Set;

import com.rabba007whizz.petclinic.model.Vet;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}

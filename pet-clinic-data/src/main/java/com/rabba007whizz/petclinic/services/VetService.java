package com.rabba007whizz.petclinic.services;

import org.springframework.data.repository.CrudRepository;

import com.rabba007whizz.petclinic.model.Vet;

public interface VetService extends CrudRepository<Vet, Long> {

}

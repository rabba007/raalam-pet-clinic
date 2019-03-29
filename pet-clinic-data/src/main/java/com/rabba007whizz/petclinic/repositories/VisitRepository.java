package com.rabba007whizz.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabba007whizz.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}

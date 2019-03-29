package com.rabba007whizz.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rabba007whizz.petclinic.model.Visit;
import com.rabba007whizz.petclinic.repositories.VisitRepository;
import com.rabba007whizz.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSdJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSdJpaService(VisitRepository visitRepository) {
        super();
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().iterator().forEachRemaining(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {

        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {

        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);

    }

}

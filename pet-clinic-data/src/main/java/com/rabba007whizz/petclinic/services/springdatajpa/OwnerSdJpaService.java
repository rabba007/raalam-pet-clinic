package com.rabba007whizz.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rabba007whizz.petclinic.model.Owner;
import com.rabba007whizz.petclinic.repositories.OwnerRepository;
import com.rabba007whizz.petclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSdJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSdJpaService(OwnerRepository ownerRepository) {

        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            return ownerOptional.get();
        }
        return null;
    }

    @Override
    public Owner save(Owner object) {

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findByLastNameLike(String lastName) {

        return ownerRepository.findByLastNameLike(lastName);
    }

}

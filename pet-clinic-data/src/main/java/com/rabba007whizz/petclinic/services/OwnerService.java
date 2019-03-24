package com.rabba007whizz.petclinic.services;

import com.rabba007whizz.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}

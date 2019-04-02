package com.rabba007whizz.petclinic.services.map;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rabba007whizz.petclinic.model.Owner;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;
    private static final Long ownerId = 1L;
    private static final String LAST_NAME = "Smith";

    @BeforeEach
    public void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(LAST_NAME).build());
    }

    @Test
    void testFindAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void testFindById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals((long) ownerId, (long) owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        ownerServiceMap.save(owner);
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void deleteAll() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteByid() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(LAST_NAME);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("NOT_FOUND");
        assertNull(owner);
    }
}

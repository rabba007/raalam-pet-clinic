package com.rabba007whizz.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rabba007whizz.petclinic.model.Owner;
import com.rabba007whizz.petclinic.model.Pet;
import com.rabba007whizz.petclinic.model.PetType;
import com.rabba007whizz.petclinic.model.Speciality;
import com.rabba007whizz.petclinic.model.Vet;
import com.rabba007whizz.petclinic.model.Visit;
import com.rabba007whizz.petclinic.services.OwnerService;
import com.rabba007whizz.petclinic.services.PetTypeService;
import com.rabba007whizz.petclinic.services.SpecialityService;
import com.rabba007whizz.petclinic.services.VetService;
import com.rabba007whizz.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService,
            SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    public void run(String... args) throws Exception {

        int count = this.petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        dogPetType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catPetType);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        specialityService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Kondapur");
        owner1.setCity("Hyderabad");
        owner1.setTelephone("3454321234");


        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenmark");
        owner2.setAddress("Kondapur");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("3454321234");
        Pet fionasPet = new Pet();
        fionasPet.setName("Kitty");
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }

}

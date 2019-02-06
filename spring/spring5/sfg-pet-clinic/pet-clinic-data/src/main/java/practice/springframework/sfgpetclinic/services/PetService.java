package practice.springframework.sfgpetclinic.services;

import practice.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);

    Pet save(Pet owner);

    Set<Pet> findAll();
}

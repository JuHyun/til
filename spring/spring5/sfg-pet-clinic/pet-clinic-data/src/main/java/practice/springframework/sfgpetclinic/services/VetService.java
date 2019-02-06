package practice.springframework.sfgpetclinic.services;

import practice.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Vet save(Vet owner);

    Set<Vet> findAll();
}

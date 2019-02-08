package practice.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.model.PetType;
import practice.springframework.sfgpetclinic.model.Vet;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;
import practice.springframework.sfgpetclinic.services.PetTypeService;
import practice.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerSerivce ownerSerivce;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerSerivce ownerSerivce, VetService vetService, PetTypeService petTypeService) {
        this.ownerSerivce = ownerSerivce;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setType("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setType("Cat");
        petTypeService.save(cat);

        System.out.println("Loaded petType...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerSerivce.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glan");

        ownerSerivce.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Angelina");
        owner3.setLastName("Joliy");

        ownerSerivce.save(owner3);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Elena");
        vet2.setLastName("Blank");

        vetService.save(vet2);

        System.out.println("Loaded vet...");
    }
}

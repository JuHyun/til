package practice.springframework.sfgpetclinic.bootstrap;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.model.Vet;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;
import practice.springframework.sfgpetclinic.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerSerivce ownerSerivce;

    private final VetService vetService;

    public DataLoader(OwnerSerivce ownerSerivce, VetService vetService) {
        this.ownerSerivce = ownerSerivce;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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

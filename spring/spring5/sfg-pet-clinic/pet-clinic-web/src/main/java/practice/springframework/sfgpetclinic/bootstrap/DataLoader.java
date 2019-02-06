package practice.springframework.sfgpetclinic.bootstrap;

import practice.springframework.sfgpetclinic.map.OwnerMapService;
import practice.springframework.sfgpetclinic.map.VetMapService;
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

    public DataLoader() {
        this.ownerSerivce = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerSerivce.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glan");

        ownerSerivce.save(owner2);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Elena");
        vet2.setLastName("Blank");

        vetService.save(vet2);

        System.out.println("Loaded vet...");
    }
}
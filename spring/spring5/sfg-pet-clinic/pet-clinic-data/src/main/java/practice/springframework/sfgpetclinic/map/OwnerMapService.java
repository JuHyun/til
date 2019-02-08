package practice.springframework.sfgpetclinic.map;

import org.springframework.stereotype.Service;
import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.model.PetType;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;
import practice.springframework.sfgpetclinic.services.PetService;
import practice.springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerSerivce {

    private final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) return null;
        if (object.getPets() == null) return super.save(object);

        object.getPets().stream().forEach(pet -> {
            savePetTypeConditional(pet.getPetType());
            savePetConditional(pet);
        });

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    private void savePetConditional(Pet pet) {
        if (pet.getId() != null) {
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
        }
    }

    private void savePetTypeConditional(PetType petType) {
        if (petType != null && petType.getId() != null) {
            petTypeService.save(petType);
        }
    }
}

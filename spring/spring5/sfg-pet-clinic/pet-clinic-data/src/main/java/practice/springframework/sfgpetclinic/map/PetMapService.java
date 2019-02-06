package practice.springframework.sfgpetclinic.map;

import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Pet findByLastName(String lastName) {
        Set<Pet> all = findAll();
        return all.stream()
                .filter(pet -> pet.getOwner().getLastName().equals(lastName))
                .findFirst().get();
    }
}

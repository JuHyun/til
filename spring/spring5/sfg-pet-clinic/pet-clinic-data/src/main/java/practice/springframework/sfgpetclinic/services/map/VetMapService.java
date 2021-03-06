package practice.springframework.sfgpetclinic.services.map;

import practice.springframework.sfgpetclinic.model.Specialty;
import practice.springframework.sfgpetclinic.model.Vet;
import practice.springframework.sfgpetclinic.services.SpecialtyService;
import practice.springframework.sfgpetclinic.services.VetService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = {"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object == null) return null;
        object.getSpecialties().forEach(specialty -> {
            saveSpecialtyConditional(specialty);
        });

        return super.save(object);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }

    private void saveSpecialtyConditional(Specialty specialty) {
        if (specialty != null && specialty.getId() == null) {
            Specialty saved = specialtyService.save(specialty);
            specialty.setId(saved.getId());
        }
    }
}

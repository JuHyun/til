package practice.springframework.sfgpetclinic.map;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerSerivce {

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
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

package practice.springframework.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable, Comparable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.id - ((BaseEntity) o).id);
    }
}

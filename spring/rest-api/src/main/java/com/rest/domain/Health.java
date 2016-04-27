package com.rest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Health Entity.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Health {

    @Id
    @GeneratedValue
    private Long id;

    private String status;

    public Health(String status) {
        this.status = status;
    }
}

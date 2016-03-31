package spittr.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Spittle Entity.
 */
@Entity
@Setter
@Getter
public class Spittle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String message;

    @NotNull
    private LocalDateTime dateTime;

    private Double latitude;

    private Double longitude;

    public Spittle() {
    }

    public Spittle(String message, LocalDateTime dateTime) {
        this(message, dateTime, null, null);
    }

    public Spittle(String message, LocalDateTime dateTime, Double longitude, Double latitude) {
        this.message = message;
        this.dateTime = dateTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

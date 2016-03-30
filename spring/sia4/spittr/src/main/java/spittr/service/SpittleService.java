package spittr.service;

import static java.time.temporal.ChronoUnit.MILLIS;

import spittr.domain.Spittle;
import spittr.repository.SpittleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SpittleService.
 */
@Service
@Transactional
public class SpittleService {

    private final SpittleRepository repository;

    @Autowired
    public SpittleService(SpittleRepository repository) {
        this.repository = repository;
    }

    public List<Spittle> findTop20() {
        return repository.findTop20ByOrderByDateTimeDesc();
    }

    public void create() {
        repository.save(createSpittles(100));
    }

    private List<Spittle> createSpittles(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();

        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle_" + i,
                    LocalDateTime.now().plus(i, MILLIS)));
        }

        return spittles;
    }
}

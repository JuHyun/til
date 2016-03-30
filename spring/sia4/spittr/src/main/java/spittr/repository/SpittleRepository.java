package spittr.repository;

import spittr.domain.Spittle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SpittleRepository.
 */
@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {

    List<Spittle> findTop20ByOrderByDateTimeDesc();
}

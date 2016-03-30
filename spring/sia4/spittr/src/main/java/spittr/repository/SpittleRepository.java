package spittr.repository;

import spittr.domain.Spittle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by seoungjuhyun on 3/30/16.
 */
@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {

    List<Spittle> findAll();
}

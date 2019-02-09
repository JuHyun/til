package practice.springframework.mvc.recipe.repositories;

import practice.springframework.mvc.recipe.domain.UnitOfMeasure;

import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}

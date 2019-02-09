package practice.springframework.mvc.recipe.repositories;

import practice.springframework.mvc.recipe.domain.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

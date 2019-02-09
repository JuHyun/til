package practice.springframework.mvc.recipe.services;

import practice.springframework.mvc.recipe.domain.Recipe;
import practice.springframework.mvc.recipe.repositories.RecipeRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> findAll() {
        Iterable<Recipe> recipes = recipeRepository.findAll();

        Set<Recipe> recipeSet = new HashSet<>();
        recipes.iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }
}

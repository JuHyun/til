package practice.springframework.mvc.recipe.controllers;

import practice.springframework.mvc.recipe.domain.Category;
import practice.springframework.mvc.recipe.domain.UnitOfMeasure;
import practice.springframework.mvc.recipe.repositories.CategoryRepository;
import practice.springframework.mvc.recipe.repositories.UnitOfMeasureRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {

    private final CategoryRepository categoryRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/index", "/index"})
    public String index() {
        Optional<Category> italian = categoryRepository.findByDescription("Italian");
        Optional<UnitOfMeasure> ounce = unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println(italian.get().getId());
        System.out.println(ounce.get().getId());

        return "index";
    }
}

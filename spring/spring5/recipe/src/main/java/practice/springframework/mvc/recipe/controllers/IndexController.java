package practice.springframework.mvc.recipe.controllers;

import practice.springframework.mvc.recipe.services.RecipeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/index", "/index"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }
}

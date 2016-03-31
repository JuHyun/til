package spittr.web;

import spittr.repository.SpittleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SpittleController.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittleList(Model model) {
        model.addAttribute("spittles",
                repository.findTop20ByOrderByDateTimeDesc());
        return "spittr/home";
    }
}

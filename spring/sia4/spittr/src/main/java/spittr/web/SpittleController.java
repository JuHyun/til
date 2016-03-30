package spittr.web;

import spittr.service.SpittleService;

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

    private SpittleService service;

    @Autowired
    public SpittleController(SpittleService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittles", service.findTop20());
        return "spittr/home";
    }
}

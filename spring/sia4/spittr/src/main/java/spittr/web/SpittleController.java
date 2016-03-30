package spittr.web;

import spittr.repository.SpittleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by seoungjuhyun on 3/30/16.
 */
@Controller
@RequestMapping("/test")
public class SpittleController {

//    private SpittleRepository spittleRepository;

//    public SpittleController() {
//    }

//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittleList() {
//        model.addAttribute("spittles", spittleRepository.findAll());
        return "spittles";
    }
}

package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import spittr.domain.Spittle;
import spittr.repository.SpittleRepository;

import static java.time.temporal.ChronoUnit.MILLIS;

/**
 * SpittleController.
 */
@Controller
@RequestMapping("/spittles")
@Transactional
public class SpittleController {

    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
        this.repository.save(createSpittles(20));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittleList(Model model) {
        model.addAttribute("spittles",
                repository.findTop20ByOrderByDateTimeDesc());
        return "spittr/spittles";
    }

    private List<Spittle> createSpittles(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();

        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle_" + i,
                    LocalDateTime.now().plus(i, MILLIS)));
        }

        Collections.reverse(spittles);

        return spittles;
    }
}

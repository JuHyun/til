package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by seoungjuhyun on 3/30/16.
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}

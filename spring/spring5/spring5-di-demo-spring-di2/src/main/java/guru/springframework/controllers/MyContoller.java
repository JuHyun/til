package guru.springframework.controllers;

import guru.services.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyContoller {

    @Autowired
    private GreetingService greetingService;

    public String hello() {
        return greetingService.sayGreeting();
    }
}

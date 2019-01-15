package guru.springframework.controllers;

import guru.springframework.services.GreetingService;

import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}

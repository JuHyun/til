package guru.springframework.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyContoller {

    public String hello() {
        System.out.println("Hello!!");

        return "Hello";
    }
}

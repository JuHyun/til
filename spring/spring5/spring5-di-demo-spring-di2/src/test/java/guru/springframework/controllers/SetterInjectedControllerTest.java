package guru.springframework.controllers;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    private SetterInjectedController controller;

    @BeforeEach
    public void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.GREETING, controller.sayHello());
    }
}

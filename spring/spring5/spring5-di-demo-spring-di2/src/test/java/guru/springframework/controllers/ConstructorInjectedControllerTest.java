package guru.springframework.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    private ConstructorInjectedController controller;

    @BeforeEach
    public void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.GREETING, controller.sayHello());
    }
}

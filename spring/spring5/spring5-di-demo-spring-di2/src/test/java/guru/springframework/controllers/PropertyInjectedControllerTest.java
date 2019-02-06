package guru.springframework.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import guru.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    private PropertyInjectedController controller;

    @BeforeEach
    public void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.GREETING, controller.sayHello());
    }
}

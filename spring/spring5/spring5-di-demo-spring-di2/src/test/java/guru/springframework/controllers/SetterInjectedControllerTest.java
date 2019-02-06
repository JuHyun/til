package guru.springframework.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import guru.services.GreetingServiceImpl;
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

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdef");

        System.out.println(stringBuilder.toString().hashCode());

        stringBuilder.append("12345678910");
        System.out.println(stringBuilder.toString().hashCode());
    }
}

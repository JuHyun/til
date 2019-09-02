package javaeight.stream.eight.strategy;


import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class ValidationStrategyTest {

    @Test
    public void strategy() {
        Validator validator = new Validator(new IsAllLowerCase());
        assertEquals(false, validator.validate("AAA"));
        assertEquals(true, validator.validate("abcde"));

        Validator validator1 = new Validator(new IsNumber());
        assertEquals(true, validator1.validate("1234"));
    }

    @Test
    public void lambdaStrategy() {
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
        assertEquals(true, numericValidator.validate("12345"));
        assertEquals(false, numericValidator.validate("a10234b"));

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        assertEquals(false, lowerCaseValidator.validate("AAA"));
        assertEquals(true, lowerCaseValidator.validate("abcde"));
    }
}

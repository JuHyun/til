package chap8;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ValidatorTest {

    @Test
    public void numericValidate() {
        Validator numericValidator = new Validator(new IsNumeric());

        assertFalse(numericValidator.validate("aaaa"));
        assertTrue(numericValidator.validate("101010"));
    }

    @Test
    public void lambdaNumericValidate() {
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));

        assertFalse(numericValidator.validate("aaaa"));
        assertTrue(numericValidator.validate("101010"));
    }

    @Test
    public void lowerCaseValidate() {
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());

        assertTrue(lowerCaseValidator.validate("abcdefg"));
        assertFalse(lowerCaseValidator.validate("a10b89"));
        assertFalse(lowerCaseValidator.validate("XYZabcde"));
    }

    @Test
    public void lambdaLowerCaseValidate() {
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));

        assertTrue(lowerCaseValidator.validate("xyz"));
        assertFalse(lowerCaseValidator.validate("AbCdEfg"));
        assertFalse(lowerCaseValidator.validate("a10b89"));
    }
}

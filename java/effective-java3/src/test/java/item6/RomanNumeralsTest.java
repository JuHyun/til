package item6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RomanNumeralsTest {

    @Test
    public void isRomanNumeral() {
        assertTrue(RomanNumerals.isRomanNumeral("MCMLXXVI"));
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        assertTrue(Palindrome.isPalindrome("Deleveled"));
        assertFalse(Palindrome.isPalindrome("abcde"));
    }
}

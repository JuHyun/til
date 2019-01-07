import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        assertTrue(Palindrome.isPalindrome("Deleveled"));
        assertFalse(Palindrome.isPalindrome("abcde"));
    }

    @Test
    public void shouldMakePalindrome() {
        assertEquals("abcba", Palindrome.makePalindrome("abc", 0, 2));
        assertEquals("thereht", Palindrome.makePalindrome("there", 0, 4));
        assertEquals("abcdcba", Palindrome.makePalindrome("abcda", 0, 4));
    }

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "abcd";
        stringBuilder.append(str, 0, 3);
        assertEquals("abc", stringBuilder.toString());
    }
}

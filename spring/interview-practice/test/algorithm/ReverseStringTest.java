package algorithm;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ReverseStringTest {

    @Test
    public void reverse() {
        assertThat(ReverseString.reverse("abcef"), equalTo("fecba"));
        assertThat(ReverseString.reverse("aabbcc"), equalTo("ccbbaa"));
        assertThat(ReverseString.reverse("abcba"), equalTo("abcba"));
    }

    @Test
    public void palindrome() {
        assertThat(ReverseString.appendLastPalindrome("abc"), equalTo("abcba"));
        assertThat(ReverseString.appendLastPalindrome("there"), equalTo("thereht"));
        assertThat(ReverseString.appendLastPalindrome("theare"), equalTo("theareraeht"));
        assertThat(ReverseString.appendLastPalindrome("aabccb"), equalTo("aabccbaa"));
    }
}
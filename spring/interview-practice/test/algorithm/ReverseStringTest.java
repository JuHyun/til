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
}
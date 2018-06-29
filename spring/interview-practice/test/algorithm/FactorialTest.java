package algorithm;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class FactorialTest {

    @Test
    public void factorial() {
        assertThat(Factorial.factorial(0), equalTo(1));
        assertThat(Factorial.factorial(1), equalTo(1));
        assertThat(Factorial.factorial(2), equalTo(2));
        assertThat(Factorial.factorial(3), equalTo(6));
        assertThat(Factorial.factorial(4), equalTo(24));
        assertThat(Factorial.factorial(5), equalTo(120));
    }
}
package algorithm;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class FibonacciTest {

    @Test
    public void fibonacchi() {
        assertThat(Fibonacci.fibonacchi(5), equalTo(3));
        assertThat(Fibonacci.fibonacchi(6), equalTo(5));
        assertThat(Fibonacci.fibonacchi(7), equalTo(8));
        assertThat(Fibonacci.fibonacchi(8), equalTo(13));
    }
}
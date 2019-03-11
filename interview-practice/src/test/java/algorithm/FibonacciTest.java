package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void success() {
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(1, Fibonacci.fibonacci(2));
        assertEquals(2, Fibonacci.fibonacci(3));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(8, Fibonacci.fibonacci(6));
    }

    @Test
    public void dynamicFibonacchi() {
        assertEquals(1, Fibonacci.dynamicFibonacci(1));
        assertEquals(1, Fibonacci.dynamicFibonacci(2));
        assertEquals(2, Fibonacci.dynamicFibonacci(3));
        assertEquals(3, Fibonacci.dynamicFibonacci(4));
        assertEquals(5, Fibonacci.dynamicFibonacci(5));
        assertEquals(8, Fibonacci.dynamicFibonacci(6));
    }
}

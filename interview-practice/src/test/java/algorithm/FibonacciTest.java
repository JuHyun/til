package algorithm;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

    @Test
    public void memoizationFibonacci() {
//        Fibonacci fibonacci1 = new Fibonacci(1);
//        assertEquals(1, fibonacci1.memoizationFibonacci(1));
//
//        Fibonacci fibonacci2 = new Fibonacci(2);
//        assertEquals(1, fibonacci2.memoizationFibonacci(2));

        Fibonacci fibonacci3 = new Fibonacci(3);
        assertEquals(2, fibonacci3.memoizationFibonacci(3));

        Fibonacci fibonacci4 = new Fibonacci(4);
        assertEquals(3, fibonacci4.memoizationFibonacci(4));

        Fibonacci fibonacci5 = new Fibonacci(5);
        assertEquals(5, fibonacci5.memoizationFibonacci(5));
    }
}

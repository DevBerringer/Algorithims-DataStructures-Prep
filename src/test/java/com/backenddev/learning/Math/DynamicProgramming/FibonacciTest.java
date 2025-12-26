package com.backenddev.learning.Math.DynamicProgramming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Fibonacci solution.
 */
public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void testFib_BaseCases() {
        assertEquals(0, fibonacci.fib(0));
        assertEquals(1, fibonacci.fib(1));
    }

    @Test
    public void testFib_SmallValues() {
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
        assertEquals(5, fibonacci.fib(5));
    }

    @Test
    public void testFib_LargerValues() {
        assertEquals(8, fibonacci.fib(6));
        assertEquals(13, fibonacci.fib(7));
        assertEquals(21, fibonacci.fib(8));
    }

    @Test
    public void testFibRecursive_BaseCases() {
        assertEquals(0, fibonacci.fibRecursive(0));
        assertEquals(1, fibonacci.fibRecursive(1));
    }

    @Test
    public void testFibRecursive_SmallValues() {
        assertEquals(1, fibonacci.fibRecursive(2));
        assertEquals(2, fibonacci.fibRecursive(3));
        assertEquals(3, fibonacci.fibRecursive(4));
        assertEquals(5, fibonacci.fibRecursive(5));
    }

    @Test
    public void testFib_Consistency() {
        // Test that both methods return the same results
        for (int i = 0; i <= 10; i++) {
            assertEquals(fibonacci.fib(i), fibonacci.fibRecursive(i));
        }
    }
}

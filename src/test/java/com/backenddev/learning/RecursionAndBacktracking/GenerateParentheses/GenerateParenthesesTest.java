package com.backenddev.learning.RecursionAndBacktracking.GenerateParentheses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GenerateParentheses solution.
 */
public class GenerateParenthesesTest {

    private GenerateParentheses generateParentheses;

    @BeforeEach
    public void setUp() {
        generateParentheses = new GenerateParentheses();
    }

    @Test
    public void testGenerateParenthesis_N1() {
        List<String> result = generateParentheses.generateParenthesis(1);
        assertEquals(1, result.size());
        assertTrue(result.contains("()"));
    }

    @Test
    public void testGenerateParenthesis_N2() {
        List<String> result = generateParentheses.generateParenthesis(2);
        assertEquals(2, result.size());
        assertTrue(result.contains("(())"));
        assertTrue(result.contains("()()"));
    }

    @Test
    public void testGenerateParenthesis_N3() {
        List<String> result = generateParentheses.generateParenthesis(3);
        assertEquals(5, result.size());
        assertTrue(result.contains("((()))"));
        assertTrue(result.contains("(()())"));
        assertTrue(result.contains("(())()"));
        assertTrue(result.contains("()(())"));
        assertTrue(result.contains("()()()"));
    }

    @Test
    public void testGenerateParenthesis_N0() {
        List<String> result = generateParentheses.generateParenthesis(0);
        assertEquals(1, result.size());
        assertTrue(result.contains(""));
    }

    @Test
    public void testIsValidParentheses_ValidCases() {
        assertTrue(generateParentheses.isValidParentheses("()"));
        assertTrue(generateParentheses.isValidParentheses("(())"));
        assertTrue(generateParentheses.isValidParentheses("()()"));
        assertTrue(generateParentheses.isValidParentheses("((()))"));
        assertTrue(generateParentheses.isValidParentheses("(()())"));
    }

    @Test
    public void testIsValidParentheses_InvalidCases() {
        assertFalse(generateParentheses.isValidParentheses("("));
        assertFalse(generateParentheses.isValidParentheses(")"));
        assertFalse(generateParentheses.isValidParentheses("())"));
        assertFalse(generateParentheses.isValidParentheses("(()"));
        assertFalse(generateParentheses.isValidParentheses(")("));
    }

    @Test
    public void testGenerateParenthesisIterative_N3() {
        List<String> result = generateParentheses.generateParenthesisIterative(3);
        assertEquals(5, result.size());
        
        // All generated combinations should be valid
        for (String combo : result) {
            assertTrue(generateParentheses.isValidParentheses(combo));
        }
    }

    @Test
    public void testGenerateParenthesis_Consistency() {
        List<String> recursive = generateParentheses.generateParenthesis(3);
        List<String> iterative = generateParentheses.generateParenthesisIterative(3);
        
        assertEquals(recursive.size(), iterative.size());
        
        for (String combo : recursive) {
            assertTrue(iterative.contains(combo));
        }
    }

    @Test
    public void testGenerateParenthesis_AllValid() {
        for (int n = 1; n <= 4; n++) {
            List<String> result = generateParentheses.generateParenthesis(n);
            
            for (String combo : result) {
                assertTrue(generateParentheses.isValidParentheses(combo));
                assertEquals(2 * n, combo.length());
            }
        }
    }
}

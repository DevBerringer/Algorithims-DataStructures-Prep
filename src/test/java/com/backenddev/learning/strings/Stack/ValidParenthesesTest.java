package com.backenddev.learning.Strings.Stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ValidParentheses solution.
 */
public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    public void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void testIsValid_ValidCases() {
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertTrue(validParentheses.isValid("{[]}"));
        assertTrue(validParentheses.isValid("((()))"));
        assertTrue(validParentheses.isValid(""));
    }

    @Test
    public void testIsValid_InvalidCases() {
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertFalse(validParentheses.isValid("((())"));
        assertFalse(validParentheses.isValid("))"));
        assertFalse(validParentheses.isValid("("));
    }

    @Test
    public void testIsValidWithHashMap_ValidCases() {
        assertTrue(validParentheses.isValidWithHashMap("()"));
        assertTrue(validParentheses.isValidWithHashMap("()[]{}"));
        assertTrue(validParentheses.isValidWithHashMap("{[]}"));
        assertTrue(validParentheses.isValidWithHashMap(""));
    }

    @Test
    public void testIsValidWithHashMap_InvalidCases() {
        assertFalse(validParentheses.isValidWithHashMap("(]"));
        assertFalse(validParentheses.isValidWithHashMap("([)]"));
        assertFalse(validParentheses.isValidWithHashMap("))"));
    }

    @Test
    public void testIsValid_Consistency() {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}", "((()))", ""};
        
        for (String testCase : testCases) {
            boolean result1 = validParentheses.isValid(testCase);
            boolean result2 = validParentheses.isValidWithHashMap(testCase);
            assertEquals(result1, result2);
        }
    }

    @Test
    public void testLongestValidParentheses_BasicCases() {
        assertEquals(2, validParentheses.longestValidParentheses("(()"));
        assertEquals(4, validParentheses.longestValidParentheses(")()())"));
        assertEquals(0, validParentheses.longestValidParentheses(""));
        assertEquals(0, validParentheses.longestValidParentheses("((("));
    }

    @Test
    public void testGenerateValidParentheses_N1() {
        var result = validParentheses.generateValidParentheses(1);
        assertEquals(1, result.size());
        assertTrue(result.contains("()"));
    }

    @Test
    public void testGenerateValidParentheses_N2() {
        var result = validParentheses.generateValidParentheses(2);
        assertEquals(2, result.size());
        assertTrue(result.contains("(())"));
        assertTrue(result.contains("()()"));
    }

    @Test
    public void testGenerateValidParentheses_N3() {
        var result = validParentheses.generateValidParentheses(3);
        assertEquals(5, result.size());
        
        // All generated combinations should be valid
        for (String combo : result) {
            assertTrue(validParentheses.isValid(combo));
        }
    }
}

package com.backenddev.learning.strings.SlidingWindow;

import org.junit.jupiter.api.Test;

import com.backenddev.learning.Strings.SlidingWindow.LongestSubstringWithoutRepeating;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LongestSubstringWithoutRepeating solution.
 */
public class LongestSubstringWithoutRepeatingTest {

    private LongestSubstringWithoutRepeating longestSubstring;

    @BeforeEach
    public void setUp() {
        longestSubstring = new LongestSubstringWithoutRepeating();
    }

    @Test
    public void testLengthOfLongestSubstring_BasicCase() {
        String s = "abcabcbb";
        int result = longestSubstring.lengthOfLongestSubstring(s);
        assertEquals(3, result);
    }

    @Test
    public void testLengthOfLongestSubstring_AllSameCharacters() {
        String s = "bbbbb";
        int result = longestSubstring.lengthOfLongestSubstring(s);
        assertEquals(1, result);
    }

    @Test
    public void testLengthOfLongestSubstring_NoRepeating() {
        String s = "pwwkew";
        int result = longestSubstring.lengthOfLongestSubstring(s);
        assertEquals(3, result);
    }

    @Test
    public void testLengthOfLongestSubstring_EmptyString() {
        String s = "";
        int result = longestSubstring.lengthOfLongestSubstring(s);
        assertEquals(0, result);
    }

    @Test
    public void testLengthOfLongestSubstring_SingleCharacter() {
        String s = "a";
        int result = longestSubstring.lengthOfLongestSubstring(s);
        assertEquals(1, result);
    }
}

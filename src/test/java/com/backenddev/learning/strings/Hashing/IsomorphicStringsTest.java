package com.backenddev.learning.strings.Hashing;

import com.backenddev.learning.Strings.Hashing.IsomorphicStrings;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for IsomorphicStrings solution.
 */
public class IsomorphicStringsTest {

    private IsomorphicStrings isomorphicStrings;

    @BeforeEach
    public void setUp() {
        isomorphicStrings = new IsomorphicStrings();
    }

    @Test
    public void testIsIsomorphic_BasicCase() {
        String s = "egg";
        String t = "add";
        assertTrue(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic_NotIsomorphic() {
        String s = "foo";
        String t = "bar";
        assertFalse(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic_SameString() {
        String s = "paper";
        String t = "title";
        assertTrue(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic_DifferentLengths() {
        String s = "ab";
        String t = "abc";
        assertFalse(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic_EmptyStrings() {
        String s = "";
        String t = "";
        assertTrue(isomorphicStrings.isIsomorphic(s, t));
    }
}

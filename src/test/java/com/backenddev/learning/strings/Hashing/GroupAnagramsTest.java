package com.backenddev.learning.Strings.Hashing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GroupAnagrams solution.
 */
public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams;

    @BeforeEach
    public void setUp() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    public void testGroupAnagrams_BasicCase() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        
        assertEquals(3, result.size());
        
        // Check that all groups are present
        boolean foundEatGroup = false;
        boolean foundTanGroup = false;
        boolean foundBatGroup = false;
        
        for (List<String> group : result) {
            if (group.size() == 3 && group.contains("eat") && group.contains("tea") && group.contains("ate")) {
                foundEatGroup = true;
            } else if (group.size() == 2 && group.contains("tan") && group.contains("nat")) {
                foundTanGroup = true;
            } else if (group.size() == 1 && group.contains("bat")) {
                foundBatGroup = true;
            }
        }
        
        assertTrue(foundEatGroup);
        assertTrue(foundTanGroup);
        assertTrue(foundBatGroup);
    }

    @Test
    public void testGroupAnagrams_EmptyArray() {
        String[] strs = {};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGroupAnagrams_SingleString() {
        String[] strs = {"a"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals("a", result.get(0).get(0));
    }

    @Test
    public void testGroupAnagrams_NoAnagrams() {
        String[] strs = {"abc", "def", "ghi"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        assertEquals(3, result.size());
        
        for (List<String> group : result) {
            assertEquals(1, group.size());
        }
    }

    @Test
    public void testGroupAnagramsWithFrequency_BasicCase() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagramsWithFrequency(strs);
        
        assertEquals(3, result.size());
    }

    @Test
    public void testGroupAnagrams_Consistency() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams.groupAnagrams(strs);
        List<List<String>> result2 = groupAnagrams.groupAnagramsWithFrequency(strs);
        
        assertEquals(result1.size(), result2.size());
    }
}

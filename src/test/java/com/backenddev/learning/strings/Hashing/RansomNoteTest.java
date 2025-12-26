package com.backenddev.learning.Strings.Hashing;

import org.junit.jupiter.api.Test;

import com.backenddev.learning.Strings.Hashing.RansomNote;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for RansomNote solution.
 */
public class RansomNoteTest {

    private RansomNote ransomNote;

    @BeforeEach
    public void setUp() {
        ransomNote = new RansomNote();
    }

    @Test
    public void testCanConstruct_BasicCase() {
        String ransomNoteStr = "a";
        String magazine = "b";
        assertFalse(ransomNote.canConstruct(ransomNoteStr, magazine));
    }

    @Test
    public void testCanConstruct_CanConstruct() {
        String ransomNoteStr = "aa";
        String magazine = "aab";
        assertTrue(ransomNote.canConstruct(ransomNoteStr, magazine));
    }

    @Test
    public void testCanConstruct_CannotConstruct() {
        String ransomNoteStr = "aa";
        String magazine = "ab";
        assertFalse(ransomNote.canConstruct(ransomNoteStr, magazine));
    }

    @Test
    public void testCanConstruct_EmptyRansomNote() {
        String ransomNoteStr = "";
        String magazine = "a";
        assertTrue(ransomNote.canConstruct(ransomNoteStr, magazine));
    }

    @Test
    public void testCanConstruct_EmptyMagazine() {
        String ransomNoteStr = "a";
        String magazine = "";
        assertFalse(ransomNote.canConstruct(ransomNoteStr, magazine));
    }
}

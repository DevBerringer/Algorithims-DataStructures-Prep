package com.backenddev.learning.Trie.ImplementTrie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ImplementTrie solution.
 */
public class ImplementTrieTest {

    private ImplementTrie.Trie trie;

    @BeforeEach
    public void setUp() {
        trie = new ImplementTrie.Trie();
    }

    @Test
    public void testInsertAndSearch_BasicCase() {
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
    }

    @Test
    public void testInsertAndSearch_MultipleWords() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertTrue(trie.search("application"));
        assertFalse(trie.search("applic"));
        assertTrue(trie.startsWith("applic"));
    }

    @Test
    public void testStartsWith_PrefixSearch() {
        trie.insert("apple");
        trie.insert("application");
        
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("apple"));
        assertTrue(trie.startsWith("applic"));
        assertFalse(trie.startsWith("xyz"));
    }

    @Test
    public void testDelete_WordRemoval() {
        trie.insert("apple");
        trie.insert("app");
        
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        
        assertTrue(trie.delete("app"));
        assertFalse(trie.search("app"));
        assertTrue(trie.search("apple"));
        assertTrue(trie.startsWith("app"));
    }

    @Test
    public void testDelete_NonExistentWord() {
        trie.insert("apple");
        
        assertFalse(trie.delete("app"));
        assertFalse(trie.delete("xyz"));
        assertTrue(trie.search("apple"));
    }

    @Test
    public void testGetWordsWithPrefix() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        
        var words = trie.getWordsWithPrefix("app");
        assertEquals(4, words.size());
        assertTrue(words.contains("app"));
        assertTrue(words.contains("apple"));
        assertTrue(words.contains("application"));
        assertTrue(words.contains("apply"));
    }

    @Test
    public void testEmptyTrie() {
        assertFalse(trie.search(""));
        assertFalse(trie.search("apple"));
        assertFalse(trie.startsWith("app"));
        assertTrue(trie.getWordsWithPrefix("app").isEmpty());
    }

    @Test
    public void testSingleCharacter() {
        trie.insert("a");
        assertTrue(trie.search("a"));
        assertTrue(trie.startsWith("a"));
        assertFalse(trie.search("ab"));
    }

    @Test
    public void testConnected_AfterOperations() {
        trie.insert("apple");
        trie.insert("app");
        
        assertTrue(trie.connected(0, 1)); // "app" and "apple" should be connected
        assertTrue(trie.delete("app"));
        assertFalse(trie.connected(0, 1)); // After deletion, they shouldn't be connected
    }
}

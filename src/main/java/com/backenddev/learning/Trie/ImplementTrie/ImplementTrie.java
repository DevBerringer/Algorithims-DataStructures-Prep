package com.backenddev.learning.Trie.ImplementTrie;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Solution for: Implement Trie (Prefix Tree).</h2>
 * <p>
 * This class provides an implementation of a Trie (prefix tree) data structure.
 * A Trie is a tree-like data structure that stores strings and allows for efficient
 * prefix-based operations like insertion, search, and prefix search.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Each node contains a character and a boolean flag indicating if it's the end of a word.</li>
 *   <li>Use an array of 26 elements to represent children (for lowercase English letters).</li>
 *   <li>Insert: traverse/create nodes for each character and mark the end.</li>
 *   <li>Search: traverse nodes and check if the end flag is set.</li>
 *   <li>StartsWith: traverse nodes and check if path exists.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(m) where m is the length of the word for all operations.</li>
 *   <li>Space complexity: O(ALPHABET_SIZE * N * M) where N is the number of words and M is the average length.</li>
 * </ul>
 */
public class ImplementTrie {

    /**
     * TrieNode class representing a node in the Trie.
     */
    public static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new TrieNode[26]; // 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    /**
     * Trie class implementing the Trie data structure.
     */
    public static class Trie {
        private TrieNode root;
        private final List<String> insertedWords;

        public Trie() {
            root = new TrieNode();
            insertedWords = new ArrayList<>();
        }

        /**
         * Insert a word into the Trie.
         *
         * @param word the word to insert
         */
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
            insertedWords.add(word);
        }

        
        /**
         * Search for a word in the Trie.
         *
         * @param word the word to search
         * @return true if the word exists in the Trie, false otherwise
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEndOfWord;
        }
        
        /**
         * Check if there is any word in the Trie that starts with the given prefix.
         *
         * @param prefix the prefix to search
         * @return true if there is a word with the given prefix, false otherwise
         */
        public boolean startsWith(String prefix) {
            System.out.println("Checking prefix: " + prefix);
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
        
        /**
         * Helper method to search for a prefix and return the node.
         *
         * @param prefix the prefix to search
         * @return the TrieNode if prefix exists, null otherwise
         */
        private TrieNode searchPrefix(String prefix) {
            TrieNode current = root;
            
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                
                if (current.children[index] == null) {
                    return null;
                }
                
                current = current.children[index];
            }
            
            return current;
        }

        /**
        * returns if the two points are connected
        *
        * @param index1 first index to compare
        * @param index2 second index to compare
        * @return true if connected. false if they are not
        */
        public boolean connected(int index1, int index2) {
            if (index1 < 0 || index2 < 0 || index1 >= insertedWords.size() || index2 >= insertedWords.size()) {
                return false;
            }

            String word1 = insertedWords.get(index1);
            String word2 = insertedWords.get(index2);

            int minLength = Math.min(word1.length(), word2.length());
            for (int i = 0; i < minLength; i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    return false;
                }
            }
            return true; // They share a common prefix
        }


        /**
         * Delete a word from the Trie.
         *
         * @param word the word to delete
         * @return true if the word was deleted, false if it didn't exist
         */
        public boolean delete(String word) {
            return deleteHelper(root, word, 0);
        }
        
        /**
         * Helper method for deletion using recursion.
         */
        private boolean deleteHelper(TrieNode node, String word, int index) {
            if (index == word.length()) {
                if (!node.isEndOfWord) {
                    return false; // Word doesn't exist
                }
                node.isEndOfWord = false;
                return isEmpty(node);
            }
            
            char c = word.charAt(index);
            int charIndex = c - 'a';
            
            if (node.children[charIndex] == null) {
                return false; // Word doesn't exist
            }
            
            boolean shouldDeleteChild = deleteHelper(node.children[charIndex], word, index + 1);
            
            if (shouldDeleteChild) {
                node.children[charIndex] = null;
                return isEmpty(node);
            }
            
            return false;
        }
        
        /**
         * Check if a node has no children.
         */
        private boolean isEmpty(TrieNode node) {
            for (TrieNode child : node.children) {
                if (child != null) {
                    return false;
                }
            }
            return true;
        }
        
        /**
         * Get all words with the given prefix.
         *
         * @param prefix the prefix to search
         * @return list of all words with the given prefix
         */
        public java.util.List<String> getWordsWithPrefix(String prefix) {
            java.util.List<String> result = new java.util.ArrayList<>();
            TrieNode node = searchPrefix(prefix);
            
            if (node != null) {
                getAllWordsFromNode(node, prefix, result);
            }
            
            return result;
        }
        
        /**
         * Helper method to get all words from a given node.
         */
        private void getAllWordsFromNode(TrieNode node, String currentWord, java.util.List<String> result) {
            if (node.isEndOfWord) {
                result.add(currentWord);
            }
            
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    char c = (char) ('a' + i);
                    getAllWordsFromNode(node.children[i], currentWord + c, result);
                }
            }
        }
    }

    /**
     * Main method to run the Implement Trie solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        // Test insertion and search
        System.out.println("Testing Trie operations:");
        
        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        trie.insert("banana");
        trie.insert("band");
        
        // Test search
        System.out.println("Search 'app': " + trie.search("app"));        // true
        System.out.println("Search 'apple': " + trie.search("apple"));    // true
        System.out.println("Search 'appl': " + trie.search("appl"));      // false
        
        // Test startsWith
        System.out.println("StartsWith 'app': " + trie.startsWith("app"));    // true
        System.out.println("StartsWith 'ban': " + trie.startsWith("ban"));    // true
        System.out.println("StartsWith 'xyz': " + trie.startsWith("xyz"));    // false
        
        // Test getWordsWithPrefix
        System.out.println("\nWords with prefix 'app': " + trie.getWordsWithPrefix("app"));
        System.out.println("Words with prefix 'ban': " + trie.getWordsWithPrefix("ban"));
        
        // Test deletion
        System.out.println("\nDeleting 'app': " + trie.delete("app"));
        System.out.println("Search 'app' after deletion: " + trie.search("app"));        // false
        System.out.println("Search 'apple' after deletion: " + trie.search("apple"));  // true
        System.out.println("StartsWith 'app' after deletion: " + trie.startsWith("app")); // true
        
        System.out.println("Words with prefix 'app' after deletion: " + trie.getWordsWithPrefix("app"));
    }
}

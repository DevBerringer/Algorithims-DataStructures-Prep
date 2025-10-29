package com.backenddev.learning.Graphs.NumberOfIslands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for NumberOfIslands solution.
 */
public class NumberOfIslandsTest {

    private NumberOfIslands numberOfIslands;

    @BeforeEach
    public void setUp() {
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    public void testNumIslands_SingleIsland() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int result = numberOfIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testNumIslands_MultipleIslands() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result = numberOfIslands.numIslands(grid);
        assertEquals(3, result);
    }

    @Test
    public void testNumIslands_NoIslands() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        int result = numberOfIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    public void testNumIslands_AllIslands() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        int result = numberOfIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testNumIslands_EmptyGrid() {
        char[][] grid = {};
        int result = numberOfIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    public void testNumIslands_NullGrid() {
        char[][] grid = null;
        int result = numberOfIslands.numIslands(grid);
        assertEquals(0, result);
    }
}

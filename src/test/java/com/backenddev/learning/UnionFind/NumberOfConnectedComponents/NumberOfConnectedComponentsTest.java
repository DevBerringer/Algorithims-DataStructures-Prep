package com.backenddev.learning.UnionFind.NumberOfConnectedComponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for NumberOfConnectedComponents solution.
 */
public class NumberOfConnectedComponentsTest {

    private NumberOfConnectedComponents numberOfConnectedComponents;

    @BeforeEach
    public void setUp() {
        numberOfConnectedComponents = new NumberOfConnectedComponents();
    }

    @Test
    public void testCountComponents_BasicCase() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        assertEquals(2, result);
    }

    @Test
    public void testCountComponents_AllConnected() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        assertEquals(1, result);
    }

    @Test
    public void testCountComponents_NoEdges() {
        int n = 3;
        int[][] edges = {};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        assertEquals(3, result);
    }

    @Test
    public void testCountComponents_SingleNode() {
        int n = 1;
        int[][] edges = {};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        assertEquals(1, result);
    }

    @Test
    public void testCountComponents_EmptyGraph() {
        int n = 0;
        int[][] edges = {};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        assertEquals(0, result);
    }

    @Test
    public void testCountComponentsDFS_BasicCase() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int result = numberOfConnectedComponents.countComponentsDFS(n, edges);
        assertEquals(2, result);
    }

    @Test
    public void testCountComponents_Consistency() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        
        int unionFindResult = numberOfConnectedComponents.countComponents(n, edges);
        int dfsResult = numberOfConnectedComponents.countComponentsDFS(n, edges);
        
        assertEquals(unionFindResult, dfsResult);
    }

    @Test
    public void testGetConnectedComponents_BasicCase() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        List<List<Integer>> result = numberOfConnectedComponents.getConnectedComponents(n, edges);
        
        assertEquals(2, result.size());
        
        // Check that all components are present
        boolean foundComponent1 = false;
        boolean foundComponent2 = false;
        
        for (List<Integer> component : result) {
            if (component.size() == 3 && component.contains(0) && component.contains(1) && component.contains(2)) {
                foundComponent1 = true;
            } else if (component.size() == 2 && component.contains(3) && component.contains(4)) {
                foundComponent2 = true;
            }
        }
        
        assertTrue(foundComponent1);
        assertTrue(foundComponent2);
    }

    @Test
    public void testWouldCreateCycle_NoCycle() {
        int n = 4;
        int[][] edges = {{0, 1}, {2, 3}};
        int[] newEdge = {0, 2};
        
        boolean result = numberOfConnectedComponents.wouldCreateCycle(n, edges, newEdge);
        assertFalse(result);
    }

    @Test
    public void testWouldCreateCycle_CreatesCycle() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        int[] newEdge = {0, 2};
        
        boolean result = numberOfConnectedComponents.wouldCreateCycle(n, edges, newEdge);
        assertTrue(result);
    }

    @Test
    public void testUnionFind_Operations() {
        NumberOfConnectedComponents.UnionFind uf = new NumberOfConnectedComponents.UnionFind(5);
        
        assertEquals(5, uf.getComponents());
        
        assertTrue(uf.union(0, 1));
        assertEquals(4, uf.getComponents());
        assertTrue(uf.connected(0, 1));
        
        assertTrue(uf.union(1, 2));
        assertEquals(3, uf.getComponents());
        assertTrue(uf.connected(0, 2));
        
        assertFalse(uf.union(0, 1)); // Already connected
        assertEquals(3, uf.getComponents());
    }
}

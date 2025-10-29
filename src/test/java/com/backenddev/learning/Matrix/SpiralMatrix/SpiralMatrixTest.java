package com.backenddev.learning.Matrix.SpiralMatrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SpiralMatrix solution.
 */
public class SpiralMatrixTest {

    private SpiralMatrix spiralMatrix;

    @BeforeEach
    public void setUp() {
        spiralMatrix = new SpiralMatrix();
    }

    @Test
    public void testSpiralOrder_BasicCase() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        List<Integer> expected = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testSpiralOrder_RectangularMatrix() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        List<Integer> expected = List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(expected, result);
    }

    @Test
    public void testSpiralOrder_SingleRow() {
        int[][] matrix = {{1, 2, 3, 4, 5}};
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testSpiralOrder_SingleColumn() {
        int[][] matrix = {{1}, {2}, {3}, {4}};
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    public void testSpiralOrder_SingleElement() {
        int[][] matrix = {{1}};
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        List<Integer> expected = List.of(1);
        assertEquals(expected, result);
    }

    @Test
    public void testSpiralOrder_EmptyMatrix() {
        int[][] matrix = {};
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSpiralOrder_NullMatrix() {
        int[][] matrix = null;
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGenerateSpiralMatrix_4x4() {
        int[][] result = spiralMatrix.generateSpiralMatrix(4);
        
        assertEquals(4, result.length);
        assertEquals(4, result[0].length);
        
        // Check that it's a proper spiral
        List<Integer> spiral = spiralMatrix.spiralOrder(result);
        for (int i = 0; i < spiral.size(); i++) {
            assertEquals(i + 1, spiral.get(i));
        }
    }

    @Test
    public void testGenerateSpiralMatrix_3x3() {
        int[][] result = spiralMatrix.generateSpiralMatrix(3);
        
        assertEquals(3, result.length);
        assertEquals(3, result[0].length);
        
        // Check specific values
        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(3, result[0][2]);
        assertEquals(4, result[1][2]);
        assertEquals(5, result[2][2]);
    }
}

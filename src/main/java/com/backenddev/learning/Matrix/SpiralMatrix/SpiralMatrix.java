package com.backenddev.learning.Matrix.SpiralMatrix;

import java.util.*;

/**
 * <h2>Solution for: Spiral Matrix.</h2>
 * <p>
 * This class provides a solution to traverse a 2D matrix in spiral order.
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use four boundaries: top, bottom, left, right.</li>
 *   <li>Traverse in four directions: right, down, left, up.</li>
 *   <li>After each direction, update the corresponding boundary.</li>
 *   <li>Continue until all elements are visited.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(m * n) where m and n are the dimensions of the matrix.</li>
 *   <li>Space complexity: O(1) excluding the output array.</li>
 * </ul>
 */
public class SpiralMatrix {

    /**
     * Method to traverse matrix in spiral order.
     *
     * @param matrix the 2D matrix to traverse
     * @return list of elements in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;
            
            // Traverse down
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            
            // Traverse left (if there are more rows)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            
            // Traverse up (if there are more columns)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        
        return result;
    }

    /**
     * Method to generate a spiral matrix of given size.
     *
     * @param n the size of the n x n matrix
     * @return 2D array representing the spiral matrix
     */
    public int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // Fill top row
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;
            
            // Fill right column
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;
            
            // Fill bottom row
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = num++;
                }
                bottom--;
            }
            
            // Fill left column
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }

    /**
     * Helper method to print a matrix.
     *
     * @param matrix the matrix to print
     */
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Main method to run the Spiral Matrix solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        
        // Test case 1: 3x3 matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Original matrix:");
        solution.printMatrix(matrix1);
        
        List<Integer> spiral1 = solution.spiralOrder(matrix1);
        System.out.println("Spiral order: " + spiral1);
        
        System.out.println();
        
        // Test case 2: 3x4 matrix
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("Original matrix:");
        solution.printMatrix(matrix2);
        
        List<Integer> spiral2 = solution.spiralOrder(matrix2);
        System.out.println("Spiral order: " + spiral2);
        
        System.out.println();
        
        // Test case 3: Generate spiral matrix
        int[][] generatedMatrix = solution.generateSpiralMatrix(4);
        System.out.println("Generated 4x4 spiral matrix:");
        solution.printMatrix(generatedMatrix);
    }
}

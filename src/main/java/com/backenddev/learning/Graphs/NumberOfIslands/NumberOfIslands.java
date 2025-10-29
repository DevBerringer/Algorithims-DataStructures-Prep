package com.backenddev.learning.Graphs.NumberOfIslands;

/**
 * <h2>Solution for: Number of Islands.</h2>
 * <p>
 * This class provides a solution to count the number of islands in a 2D grid.
 * An island is formed by connecting adjacent lands horizontally or vertically.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use Depth-First Search (DFS) to explore each island.</li>
 *   <li>Traverse the grid and when we find land ('1'), start DFS to mark all connected land.</li>
 *   <li>Mark visited cells to avoid counting the same island multiple times.</li>
 *   <li>Increment island count each time we start a new DFS.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(m * n) where m and n are the dimensions of the grid.</li>
 *   <li>Space complexity: O(m * n) in the worst case for the recursion stack.</li>
 * </ul>
 */
public class NumberOfIslands {

    /**
     * Method to count the number of islands in a 2D grid.
     *
     * @param grid the 2D grid where '1' represents land and '0' represents water
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    /**
     * Helper method to perform DFS and mark all connected land as visited.
     *
     * @param grid the 2D grid
     * @param row current row index
     * @param col current column index
     * @param rows total number of rows
     * @param cols total number of columns
     */
    private void dfs(char[][] grid, int row, int col, int rows, int cols) {
        // Check bounds and if current cell is water or already visited
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1') {
            return;
        }

        // Mark current cell as visited by setting it to '0'
        grid[row][col] = '0';

        // Explore all four directions
        dfs(grid, row + 1, col, rows, cols); // down
        dfs(grid, row - 1, col, rows, cols); // up
        dfs(grid, row, col + 1, rows, cols); // right
        dfs(grid, row, col - 1, rows, cols); // left
    }

    /**
     * Main method to run the Number of Islands solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        
        // Test case 1
        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        
        int result1 = solution.numIslands(grid1);
        System.out.println("Number of islands in grid1: " + result1);
        
        // Test case 2
        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        
        int result2 = solution.numIslands(grid2);
        System.out.println("Number of islands in grid2: " + result2);
    }
}

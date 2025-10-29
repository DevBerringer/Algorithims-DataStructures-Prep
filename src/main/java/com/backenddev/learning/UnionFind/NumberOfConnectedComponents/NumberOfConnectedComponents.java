package com.backenddev.learning.UnionFind.NumberOfConnectedComponents;

/**
 * <h2>Solution for: Number of Connected Components in an Undirected Graph.</h2>
 * <p>
 * This class provides a solution to find the number of connected components in an undirected graph
 * using Union-Find (Disjoint Set Union) data structure.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use Union-Find data structure to efficiently manage connected components.</li>
 *   <li>Initially, each node is its own parent (separate component).</li>
 *   <li>For each edge, union the two nodes if they're not already connected.</li>
 *   <li>Count the number of distinct roots (components) at the end.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n * α(n)) where α is the inverse Ackermann function (nearly constant).</li>
 *   <li>Space complexity: O(n) for the parent and rank arrays.</li>
 * </ul>
 */
public class NumberOfConnectedComponents {

    /**
     * Union-Find data structure implementation.
     */
    public static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            
            // Initialize each node as its own parent
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        /**
         * Find the root of the given node with path compression.
         *
         * @param x the node to find root for
         * @return the root of the node
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        /**
         * Union two nodes if they're not already connected.
         *
         * @param x first node
         * @param y second node
         * @return true if union was performed, false if already connected
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) {
                return false; // Already connected
            }
            
            // Union by rank
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            
            components--; // Decrease component count
            return true;
        }
        
        /**
         * Check if two nodes are connected.
         *
         * @param x first node
         * @param y second node
         * @return true if connected, false otherwise
         */
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        /**
         * Get the number of connected components.
         *
         * @return number of connected components
         */
        public int getComponents() {
            return components;
        }
    }

    /**
     * Method to count connected components using Union-Find.
     *
     * @param n number of nodes
     * @param edges array of edges where each edge is represented as [u, v]
     * @return number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        // Process each edge
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.getComponents();
    }

    /**
     * Alternative method using DFS to count connected components.
     *
     * @param n number of nodes
     * @param edges array of edges
     * @return number of connected components
     */
    public int countComponentsDFS(int n, int[][] edges) {
        // Build adjacency list
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new java.util.ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                components++;
            }
        }
        
        return components;
    }

    /**
     * DFS helper method for counting components.
     */
    private void dfs(java.util.List<java.util.List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    /**
     * Method to find all connected components and return their members.
     *
     * @param n number of nodes
     * @param edges array of edges
     * @return list of connected components
     */
    public java.util.List<java.util.List<Integer>> getConnectedComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        // Process each edge
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        // Group nodes by their root
        java.util.Map<Integer, java.util.List<Integer>> components = new java.util.HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new java.util.ArrayList<>()).add(i);
        }
        
        return new java.util.ArrayList<>(components.values());
    }

    /**
     * Method to check if adding an edge would create a cycle.
     *
     * @param n number of nodes
     * @param edges existing edges
     * @param newEdge the new edge to check
     * @return true if adding the edge would create a cycle
     */
    public boolean wouldCreateCycle(int n, int[][] edges, int[] newEdge) {
        UnionFind uf = new UnionFind(n);
        
        // Process existing edges
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        // Check if the new edge connects already connected components
        return uf.connected(newEdge[0], newEdge[1]);
    }

    /**
     * Main method to run the Number of Connected Components solution.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
        
        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        
        System.out.println("Test case 1:");
        System.out.println("n = " + n1 + ", edges = " + java.util.Arrays.deepToString(edges1));
        
        int components1 = solution.countComponents(n1, edges1);
        System.out.println("Number of connected components (Union-Find): " + components1);
        
        int componentsDFS1 = solution.countComponentsDFS(n1, edges1);
        System.out.println("Number of connected components (DFS): " + componentsDFS1);
        
        java.util.List<java.util.List<Integer>> componentsList1 = solution.getConnectedComponents(n1, edges1);
        System.out.println("Connected components: " + componentsList1);
        System.out.println();
        
        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        
        System.out.println("Test case 2:");
        System.out.println("n = " + n2 + ", edges = " + java.util.Arrays.deepToString(edges2));
        
        int components2 = solution.countComponents(n2, edges2);
        System.out.println("Number of connected components: " + components2);
        
        java.util.List<java.util.List<Integer>> componentsList2 = solution.getConnectedComponents(n2, edges2);
        System.out.println("Connected components: " + componentsList2);
        System.out.println();
        
        // Test case 3: No edges
        int n3 = 3;
        int[][] edges3 = {};
        
        System.out.println("Test case 3 (no edges):");
        System.out.println("n = " + n3 + ", edges = " + java.util.Arrays.deepToString(edges3));
        
        int components3 = solution.countComponents(n3, edges3);
        System.out.println("Number of connected components: " + components3);
        System.out.println();
        
        // Test cycle detection
        System.out.println("Testing cycle detection:");
        int[] newEdge = {0, 2};
        boolean wouldCreateCycle = solution.wouldCreateCycle(n1, edges1, newEdge);
        System.out.println("Would adding edge " + java.util.Arrays.toString(newEdge) + " create a cycle? " + wouldCreateCycle);
    }
}

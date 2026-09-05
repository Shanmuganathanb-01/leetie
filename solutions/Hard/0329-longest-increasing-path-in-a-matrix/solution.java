// ──────────────────────────────────────────────────
// Problem  : 329. Longest Increasing Path in a Matrix
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Memoization, Matrix, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Runtime  : 8 ms (beats 87%)
// Memory   : 47108000 (beats 47%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int maxPath = 1;

        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, nr, nc, memo));
            }
        }

        memo[r][c] = maxPath;
        return maxPath;
    }
}
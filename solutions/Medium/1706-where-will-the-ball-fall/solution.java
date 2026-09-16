// ──────────────────────────────────────────────────
// Problem  : 1706. Where Will the Ball Fall
// Difficulty: Medium
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/where-will-the-ball-fall/
// Runtime  : 3 ms (beats 82%)
// Memory   : 46924000 (beats 92%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        
        for (int col = 0; col < n; col++) {
            int currCol = col;
            boolean stuck = false;
            
            for (int row = 0; row < m; row++) {
                int nextCol = currCol + grid[row][currCol];
                
                if (nextCol < 0 || nextCol >= n || grid[row][currCol] != grid[row][nextCol]) {
                    stuck = true;
                    break;
                }
                
                currCol = nextCol;
            }
            
            result[col] = stuck ? -1 : currCol;
        }
        
        return result;
    }
}
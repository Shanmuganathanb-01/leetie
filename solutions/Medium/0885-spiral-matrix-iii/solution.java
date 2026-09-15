// ──────────────────────────────────────────────────
// Problem  : 885. Spiral Matrix III
// Difficulty: Medium
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/spiral-matrix-iii/
// Runtime  : 5 ms (beats 39%)
// Memory   : 46924000 (beats 78%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int r = rStart, c = cStart;
        int len = 0;
        int d = 0;
        int count = 0;
        
        res[count++] = new int[]{r, c};
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (count < rows * cols) {
            if (d == 0 || d == 2) {
                len++;
            }
            
            for (int i = 0; i < len; i++) {
                r += dirs[d][0];
                c += dirs[d][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[count++] = new int[]{r, c};
                }
            }
            
            d = (d + 1) % 4;
        }
        
        return res;
    }
}
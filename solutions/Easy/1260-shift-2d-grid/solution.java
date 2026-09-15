// ──────────────────────────────────────────────────
// Problem  : 1260. Shift 2D Grid
// Difficulty: Easy
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/shift-2d-grid/
// Runtime  : 5 ms (beats 89%)
// Memory   : 47060000 (beats 78%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;
        
        int[][] res = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int flatIndex = (r * n + c - k % total + total) % total;
                res[r][c] = grid[flatIndex / n][flatIndex % n];
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : res) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            result.add(list);
        }
        return result;
    }
}
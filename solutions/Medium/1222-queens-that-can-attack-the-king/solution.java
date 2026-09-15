// ──────────────────────────────────────────────────
// Problem  : 1222. Queens That Can Attack the King
// Difficulty: Medium
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/queens-that-can-attack-the-king/
// Runtime  : 1 ms (beats 81%)
// Memory   : 44104000 (beats 72%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public java.util.List<java.util.List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] isQueen = new boolean[8][8];
        for (int[] q : queens) {
            isQueen[q[0]][q[1]] = true;
        }
        
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        int[] dirs = {-1, 0, 1};
        
        for (int dx : dirs) {
            for (int dy : dirs) {
                if (dx == 0 && dy == 0) continue;
                
                int x = king[0] + dx;
                int y = king[1] + dy;
                
                while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (isQueen[x][y]) {
                        result.add(java.util.Arrays.asList(x, y));
                        break;
                    }
                    x += dx;
                    y += dy;
                }
            }
        }
        
        return result;
    }
}
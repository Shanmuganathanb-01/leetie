// ──────────────────────────────────────────────────
// Problem  : 999. Available Captures for Rook
// Difficulty: Easy
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/available-captures-for-rook/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42812000 (beats 26%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numRookCaptures(char[][] board) {
        int r = 0, c = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == 'B') {
                    break;
                }
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        
        return count;
    }
}
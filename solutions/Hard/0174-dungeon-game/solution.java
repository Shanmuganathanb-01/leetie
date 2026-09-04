// ──────────────────────────────────────────────────
// Problem  : 174. Dungeon Game
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Matrix
// Link     : https://leetcode.com/problems/dungeon-game/
// Runtime  : 2 ms (beats 69%)
// Memory   : 45468000 (beats 21%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    int minNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, minNext - dungeon[i][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}
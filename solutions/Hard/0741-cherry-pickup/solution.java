// ──────────────────────────────────────────────────
// Problem  : 741. Cherry Pickup
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Matrix
// Link     : https://leetcode.com/problems/cherry-pickup/
// Runtime  : 19 ms (beats 31%)
// Memory   : 46852000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            java.util.Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];
        
        for (int t = 1; t <= 2 * N - 2; t++) {
            int[][] dp2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                java.util.Arrays.fill(dp2[i], Integer.MIN_VALUE);
            }
            
            for (int i = Math.max(0, t - (N - 1)); i <= Math.min(N - 1, t); i++) {
                for (int j = Math.max(0, t - (N - 1)); j <= Math.min(N - 1, t); j++) {
                    if (grid[t - i][i] == -1 || grid[t - j][j] == -1) {
                        continue;
                    }
                    
                    int val = grid[t - i][i];
                    if (i != j) {
                        val += grid[t - j][j];
                    }
                    
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = j - 1; pj <= j; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][j] = Math.max(dp2[i][j], dp[pi][pj] + val);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        
        return Math.max(0, dp[N - 1][N - 1]);
    }
}
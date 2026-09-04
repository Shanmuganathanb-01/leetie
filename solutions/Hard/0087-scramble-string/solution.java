// ──────────────────────────────────────────────────
// Problem  : 87. Scramble String
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/scramble-string/
// Runtime  : 7 ms (beats 73%)
// Memory   : 44520000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n) {
            return false;
        }
        
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                for (int j = 0; j <= n - length; j++) {
                    if (length == 1) {
                        dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    
                    for (int k = 1; k < length; k++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][length - k]) || 
                            (dp[i][j + length - k][k] && dp[i + k][j][length - k])) {
                            dp[i][j][length] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}
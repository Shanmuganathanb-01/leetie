// ──────────────────────────────────────────────────
// Problem  : 940. Distinct Subsequences II
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/distinct-subsequences-ii/
// Runtime  : 6 ms (beats 44%)
// Memory   : 42980000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long[] dp = new long[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            long total = 1;
            for (int j = 0; j < 26; j++) {
                total = (total + dp[j]) % MOD;
            }
            dp[c] = total;
        }
        
        long ans = 0;
        for (int j = 0; j < 26; j++) {
            ans = (ans + dp[j]) % MOD;
        }
        return (int) ans;
    }
}
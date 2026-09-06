// ──────────────────────────────────────────────────
// Problem  : 354. Russian Doll Envelopes
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/russian-doll-envelopes/
// Runtime  : 38 ms (beats 95%)
// Memory   : 99088000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        java.util.Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        
        for (int[] env : envelopes) {
            int height = env[1];
            int index = java.util.Arrays.binarySearch(dp, 0, len, height);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = height;
            if (index == len) {
                len++;
            }
        }
        
        return len;
    }
}
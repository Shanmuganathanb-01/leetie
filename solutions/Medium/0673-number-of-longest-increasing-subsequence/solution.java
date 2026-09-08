// ──────────────────────────────────────────────────
// Problem  : 673. Number of Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Binary Indexed Tree, Segment Tree, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42308000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        
        int[] dp = new int[n];
        int[] count = new int[n];
        java.util.Arrays.fill(dp, 1);
        java.util.Arrays.fill(count, 1);
        
        int maxLength = 1;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                res += count[i];
            }
        }
        
        return res;
    }
}
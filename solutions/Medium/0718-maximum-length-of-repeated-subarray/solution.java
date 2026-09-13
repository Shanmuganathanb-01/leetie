// ──────────────────────────────────────────────────
// Problem  : 718. Maximum Length of Repeated Subarray
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Sliding Window, Rolling Hash, Hash Function
// Link     : https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42448000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    if (dp[j] > maxLen) {
                        maxLen = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
            }
        }
        
        return maxLen;
    }
}
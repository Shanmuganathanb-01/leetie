// ──────────────────────────────────────────────────
// Problem  : 3903. Smallest Stable Index I
// Difficulty: Easy
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/smallest-stable-index-i/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46188000 (beats 88%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        int prefixMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
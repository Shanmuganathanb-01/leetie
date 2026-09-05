// ──────────────────────────────────────────────────
// Problem  : 303. Range Sum Query - Immutable
// Difficulty: Easy
// Tags     : Array, Design, Prefix Sum
// Link     : https://leetcode.com/problems/range-sum-query-immutable/
// Runtime  : 8 ms (beats 70%)
// Memory   : 47484000 (beats 91%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
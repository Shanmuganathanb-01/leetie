// ──────────────────────────────────────────────────
// Problem  : 724. Find Pivot Index
// Difficulty: Easy
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/find-pivot-index/
// Runtime  : 1 ms (beats 96%)
// Memory   : 47332000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}
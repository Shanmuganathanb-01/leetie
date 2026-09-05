// ──────────────────────────────────────────────────
// Problem  : 213. House Robber II
// Difficulty: Medium
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/house-robber-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42428000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }
    
    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 674. Longest Continuous Increasing Subsequence
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/longest-continuous-increasing-subsequence/
// Runtime  : 2 ms (beats 48%)
// Memory   : 46684000 (beats 88%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}
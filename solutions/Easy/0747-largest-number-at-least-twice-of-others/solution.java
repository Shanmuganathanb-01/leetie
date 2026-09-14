// ──────────────────────────────────────────────────
// Problem  : 747. Largest Number At Least Twice of Others
// Difficulty: Easy
// Tags     : Array, Sorting
// Link     : https://leetcode.com/problems/largest-number-at-least-twice-of-others/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42804000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int maxIndex = -1;
        int secondMax = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        
        if (max >= secondMax * 2) {
            return maxIndex;
        }
        return -1;
    }
}
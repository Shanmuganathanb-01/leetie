// ──────────────────────────────────────────────────
// Problem  : 485. Max Consecutive Ones
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/max-consecutive-ones/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42668000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 643. Maximum Average Subarray I
// Difficulty: Easy
// Tags     : Array, Sliding Window
// Link     : https://leetcode.com/problems/maximum-average-subarray-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 45192000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum / k;
    }
}
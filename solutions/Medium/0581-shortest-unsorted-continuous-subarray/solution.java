// ──────────────────────────────────────────────────
// Problem  : 581. Shortest Unsorted Continuous Subarray
// Difficulty: Medium
// Tags     : Array, Two Pointers, Stack, Greedy, Sorting, Monotonic Stack
// Link     : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42600000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        
        int right = -1;
        int left = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            int j = n - 1 - i;
            if (nums[j] > min) {
                left = j;
            } else {
                min = nums[j];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}
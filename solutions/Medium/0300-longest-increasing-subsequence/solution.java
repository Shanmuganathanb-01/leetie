// ──────────────────────────────────────────────────
// Problem  : 300. Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/longest-increasing-subsequence/
// Runtime  : 3 ms (beats 96%)
// Memory   : 45856000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            tails[left] = num;
            if (left == size) {
                size++;
            }
        }
        
        return size;
    }
}
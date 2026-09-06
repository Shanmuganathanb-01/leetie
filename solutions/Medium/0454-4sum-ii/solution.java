// ──────────────────────────────────────────────────
// Problem  : 454. 4Sum II
// Difficulty: Medium
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/4sum-ii/
// Runtime  : 109 ms (beats 81%)
// Memory   : 47208000 (beats 6%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }
        
        return count;
    }
}
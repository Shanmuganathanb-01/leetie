// ──────────────────────────────────────────────────
// Problem  : 164. Maximum Gap
// Difficulty: Medium
// Tags     : Array, Sorting, Bucket Sort, Radix Sort, Pigeonhole Principle
// Link     : https://leetcode.com/problems/maximum-gap/
// Runtime  : 10 ms (beats 97%)
// Memory   : 90404000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        if (min == max) {
            return 0;
        }
        
        int n = nums.length;
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);
        
        for (int i : nums) {
            if (i == min || i == max) continue;
            int idx = (i - min) / gap;
            bucketMin[idx] = Math.min(i, bucketMin[idx]);
            bucketMax[idx] = Math.max(i, bucketMax[idx]);
        }
        
        int maxGap = 0;
        int prev = min;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        
        maxGap = Math.max(maxGap, max - prev);
        
        return maxGap;
    }
}
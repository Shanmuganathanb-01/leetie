// ──────────────────────────────────────────────────
// Problem  : 689. Maximum Sum of 3 Non-Overlapping Subarrays
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42976000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                sums[i - k + 1] = sum;
                sum -= nums[i - k + 1];
            }
        }
        
        int[] left = new int[sums.length];
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        int[] right = new int[sums.length];
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        int[] res = new int[]{-1, -1, -1};
        int maxTotal = 0;
        for (int j = k; j <= sums.length - k - 1; j++) {
            int l = left[j - k];
            int r = right[j + k];
            int total = sums[l] + sums[j] + sums[r];
            if (total > maxTotal) {
                maxTotal = total;
                res = new int[]{l, j, r};
            }
        }
        
        return res;
    }
}
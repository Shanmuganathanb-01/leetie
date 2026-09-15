// ──────────────────────────────────────────────────
// Problem  : 985. Sum of Even Numbers After Queries
// Difficulty: Medium
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/sum-of-even-numbers-after-queries/
// Runtime  : 4 ms (beats 100%)
// Memory   : 52944000 (beats 14%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sumEven = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                sumEven += x;
            }
        }
        
        int n = queries.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            
            if (nums[idx] % 2 == 0) {
                sumEven -= nums[idx];
            }
            
            nums[idx] += val;
            
            if (nums[idx] % 2 == 0) {
                sumEven += nums[idx];
            }
            
            ans[i] = sumEven;
        }
        
        return ans;
    }
}
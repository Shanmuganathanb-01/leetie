// ──────────────────────────────────────────────────
// Problem  : 494. Target Sum
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/target-sum/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42468000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }
        
        int s2 = (target + sum) / 2;
        int[] dp = new int[s2 + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = s2; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[s2];
    }
}
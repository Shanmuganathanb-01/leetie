// ──────────────────────────────────────────────────
// Problem  : 746. Min Cost Climbing Stairs
// Difficulty: Easy
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/min-cost-climbing-stairs/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44816000 (beats 59%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        
        return Math.min(first, second);
    }
}
// ──────────────────────────────────────────────────
// Problem  : 740. Delete and Earn
// Difficulty: Medium
// Tags     : Array, Hash Table, Dynamic Programming
// Link     : https://leetcode.com/problems/delete-and-earn/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42528000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }
        
        int twoBack = 0;
        int oneBack = 0;
        
        for (int i = 0; i <= max; i++) {
            int current = Math.max(oneBack, twoBack + points[i]);
            twoBack = oneBack;
            oneBack = current;
        }
        
        return oneBack;
    }
}
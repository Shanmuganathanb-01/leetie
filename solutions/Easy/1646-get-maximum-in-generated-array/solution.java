// ──────────────────────────────────────────────────
// Problem  : 1646. Get Maximum in Generated Array
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/get-maximum-in-generated-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41888000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        
        for (int i = 1; 2 * i <= n; i++) {
            nums[2 * i] = nums[i];
            max = Math.max(max, nums[2 * i]);
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
        }
        
        return max;
    }
}
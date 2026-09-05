// ──────────────────────────────────────────────────
// Problem  : 330. Patching Array
// Difficulty: Hard
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/patching-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45468000 (beats 23%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;
        int len = nums.length;
        
        while (miss <= n) {
            if (i < len && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }
}
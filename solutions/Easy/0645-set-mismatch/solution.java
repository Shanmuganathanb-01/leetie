// ──────────────────────────────────────────────────
// Problem  : 645. Set Mismatch
// Difficulty: Easy
// Tags     : Array, Hash Table, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/set-mismatch/
// Runtime  : 3 ms (beats 69%)
// Memory   : 47496000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1, missing = -1;
        
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[idx] = -nums[idx];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        return new int[] { dup, missing };
    }
}
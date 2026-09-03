// ──────────────────────────────────────────────────
// Problem  : 80. Remove Duplicates from Sorted Array II
// Difficulty: Medium
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 48572000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
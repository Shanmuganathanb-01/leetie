// ──────────────────────────────────────────────────
// Problem  : 324. Wiggle Sort II
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Greedy, Sorting, Quickselect
// Link     : https://leetcode.com/problems/wiggle-sort-ii/
// Runtime  : 8 ms (beats 97%)
// Memory   : 49080000 (beats 24%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int left = (n - 1) / 2;
        int right = n - 1;
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}
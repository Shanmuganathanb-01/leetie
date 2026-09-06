// ──────────────────────────────────────────────────
// Problem  : 442. Find All Duplicates in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Runtime  : 0 ms (beats 0%)
// Memory   : 43104000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 491. Non-decreasing Subsequences
// Difficulty: Medium
// Tags     : Array, Hash Table, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/non-decreasing-subsequences/
// Runtime  : 19 ms (beats 16%)
// Memory   : 53248000 (beats 36%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, Set<List<Integer>> result) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                current.add(nums[i]);
                backtrack(nums, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
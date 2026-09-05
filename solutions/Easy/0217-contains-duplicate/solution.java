// ──────────────────────────────────────────────────
// Problem  : 217. Contains Duplicate
// Difficulty: Easy
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/contains-duplicate/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42172000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
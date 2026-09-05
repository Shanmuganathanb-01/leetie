// ──────────────────────────────────────────────────
// Problem  : 219. Contains Duplicate II
// Difficulty: Easy
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/contains-duplicate-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41976000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
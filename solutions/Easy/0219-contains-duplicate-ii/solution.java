// ──────────────────────────────────────────────────
// Problem  : 219. Contains Duplicate II
// Difficulty: Easy
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/contains-duplicate-ii/
// Runtime  : 38 ms (beats 6%)
// Memory   : 125192000 (beats 6%)
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
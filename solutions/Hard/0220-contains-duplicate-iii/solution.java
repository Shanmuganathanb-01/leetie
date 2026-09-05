// ──────────────────────────────────────────────────
// Problem  : 220. Contains Duplicate III
// Difficulty: Hard
// Tags     : Array, Sliding Window, Sorting, Bucket Sort, Ordered Set
// Link     : https://leetcode.com/problems/contains-duplicate-iii/
// Runtime  : 199 ms (beats 14%)
// Memory   : 127356000 (beats 5%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i] + valueDiff);
            Long ceil = set.ceiling((long) nums[i] - valueDiff);
            
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            
            set.add((long) nums[i]);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
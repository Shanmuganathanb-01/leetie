// ──────────────────────────────────────────────────
// Problem  : 287. Find the Duplicate Number
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Bit Manipulation, Pigeonhole Principle, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/find-the-duplicate-number/
// Runtime  : 5 ms (beats 63%)
// Memory   : 83000000 (beats 48%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 704. Binary Search
// Difficulty: Easy
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/binary-search/
// Runtime  : 0 ms (beats 100%)
// Memory   : 48220000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
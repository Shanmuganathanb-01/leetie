// ──────────────────────────────────────────────────
// Problem  : 167. Two Sum II - Input Array Is Sorted
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search
// Link     : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Runtime  : 2 ms (beats 96%)
// Memory   : 48408000 (beats 42%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
}
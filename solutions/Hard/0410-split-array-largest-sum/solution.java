// ──────────────────────────────────────────────────
// Problem  : 410. Split Array Largest Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Greedy, Prefix Sum
// Link     : https://leetcode.com/problems/split-array-largest-sum/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43260000 (beats 17%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int splitArray(int[] nums, int k) {
        long left = 0;
        long right = 0;
        
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        
        long ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) ans;
    }
    
    private boolean isValid(int[] nums, int k, long maxSum) {
        int count = 1;
        long currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
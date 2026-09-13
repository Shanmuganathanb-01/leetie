// ──────────────────────────────────────────────────
// Problem  : 697. Degree of an Array
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/degree-of-an-array/
// Runtime  : 5 ms (beats 99%)
// Memory   : 49244000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] first = new int[50000];
        int[] last = new int[50000];
        int degree = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 0) {
                first[nums[i]] = i;
            }
            last[nums[i]] = i;
            count[nums[i]]++;
            if (count[nums[i]] > degree) {
                degree = count[nums[i]];
            }
        }
        
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == degree) {
                int len = last[nums[i]] - first[nums[i]] + 1;
                if (len < minLen) {
                    minLen = len;
                }
            }
        }
        
        return minLen;
    }
}
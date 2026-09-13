// ──────────────────────────────────────────────────
// Problem  : 697. Degree of an Array
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/degree-of-an-array/
// Runtime  : 2 ms (beats 0%)
// Memory   : 43520000 (beats 0%)
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
        for (int i = 0; i < 50000; i++) {
            if (count[i] == degree) {
                int len = last[i] - first[i] + 1;
                if (len < minLen) {
                    minLen = len;
                }
            }
        }
        
        return minLen;
    }
}
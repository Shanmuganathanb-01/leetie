// ──────────────────────────────────────────────────
// Problem  : 3904. Smallest Stable Index II
// Difficulty: Medium
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/smallest-stable-index-ii/
// Runtime  : 6 ms (beats 46%)
// Memory   : 126760000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        
        prefMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }
        
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (prefMax[i] - suffMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
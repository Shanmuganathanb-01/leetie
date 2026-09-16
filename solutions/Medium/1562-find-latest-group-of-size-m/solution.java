// ──────────────────────────────────────────────────
// Problem  : 1562. Find Latest Group of Size M
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Simulation
// Link     : https://leetcode.com/problems/find-latest-group-of-size-m/
// Runtime  : 4 ms (beats 99%)
// Memory   : 89140000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        
        int[] length = new int[n + 2];
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int left = length[a - 1];
            int right = length[a + 1];
            
            int total = left + right + 1;
            length[a - left] = total;
            length[a + right] = total;
            
            if (left == m || right == m) {
                ans = i;
            }
        }
        
        return ans;
    }
}
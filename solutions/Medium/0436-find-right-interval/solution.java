// ──────────────────────────────────────────────────
// Problem  : 436. Find Right Interval
// Difficulty: Medium
// Tags     : Array, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-right-interval/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42244000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        
        java.util.Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int left = 0, right = n - 1;
            int targetIndex = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= end) {
                    targetIndex = starts[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            result[i] = targetIndex;
        }
        
        return result;
    }
}
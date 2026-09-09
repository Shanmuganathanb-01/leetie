// ──────────────────────────────────────────────────
// Problem  : 1848. Minimum Distance to the Target Element
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/minimum-distance-to-the-target-element/
// Runtime  : 1 ms (beats 68%)
// Memory   : 45316000 (beats 6%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDistance = Math.min(minDistance, Math.abs(i - start));
            }
        }
        return minDistance;
    }
}
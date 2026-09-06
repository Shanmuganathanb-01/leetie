// ──────────────────────────────────────────────────
// Problem  : 452. Minimum Number of Arrows to Burst Balloons
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42092000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        java.util.Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}
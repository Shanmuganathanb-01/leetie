// ──────────────────────────────────────────────────
// Problem  : 836. Rectangle Overlap
// Difficulty: Easy
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/rectangle-overlap/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42864000 (beats 18%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || 
                 rec1[3] <= rec2[1] || 
                 rec1[0] >= rec2[2] || 
                 rec1[1] >= rec2[3]);
    }
}
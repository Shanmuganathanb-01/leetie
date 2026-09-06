// ──────────────────────────────────────────────────
// Problem  : 406. Queue Reconstruction by Height
// Difficulty: Medium
// Tags     : Array, Binary Indexed Tree, Segment Tree, Sorting
// Link     : https://leetcode.com/problems/queue-reconstruction-by-height/
// Runtime  : 6 ms (beats 99%)
// Memory   : 47120000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        java.util.Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        java.util.List<int[]> result = new java.util.ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        
        return result.toArray(new int[people.length][]);
    }
}
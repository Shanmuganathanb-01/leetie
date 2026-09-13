// ──────────────────────────────────────────────────
// Problem  : 835. Image Overlap
// Difficulty: Medium
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/image-overlap/
// Runtime  : 18 ms (beats 98%)
// Memory   : 46340000 (beats 52%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        java.util.List<int[]> list1 = new java.util.ArrayList<>();
        java.util.List<int[]> list2 = new java.util.ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) list1.add(new int[]{i, j});
                if (img2[i][j] == 1) list2.add(new int[]{i, j});
            }
        }
        
        int[] count = new int[6000];
        int maxOverlap = 0;
        
        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                int dx = p1[0] - p2[0] + 30;
                int dy = p1[1] - p2[1] + 30;
                int key = dx * 100 + dy;
                count[key]++;
                if (count[key] > maxOverlap) {
                    maxOverlap = count[key];
                }
            }
        }
        
        return maxOverlap;
    }
}
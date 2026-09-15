// ──────────────────────────────────────────────────
// Problem  : 832. Flipping an Image
// Difficulty: Easy
// Tags     : Array, Two Pointers, Bit Manipulation, Matrix, Simulation
// Link     : https://leetcode.com/problems/flipping-an-image/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45860000 (beats 37%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            for (int i = 0; i < (n + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[n - 1 - i] ^ 1;
                row[n - 1 - i] = temp;
            }
        }
        return image;
    }
}
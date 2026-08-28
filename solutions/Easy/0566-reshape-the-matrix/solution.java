// ──────────────────────────────────────────────────
// Problem  : 566. Reshape the Matrix
// Difficulty: Easy
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/reshape-the-matrix/
// Runtime  : 0 ms (beats 100%)
// Memory   : 47368000 (beats 58%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];

        for (int i = 0; i < m * n; i++) {
            reshaped[i / c][i % c] = mat[i / n][i % n];
        }

        return reshaped;
    }
}
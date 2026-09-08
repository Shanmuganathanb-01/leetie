// ──────────────────────────────────────────────────
// Problem  : 661. Image Smoother
// Difficulty: Easy
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/image-smoother/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42616000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }
                
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}
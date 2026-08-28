// ──────────────────────────────────────────────────
// Problem  : 546. Remove Boxes
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Memoization
// Link     : https://leetcode.com/problems/remove-boxes/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42684000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return calculate(boxes, 0, n - 1, 0, dp);
    }

    private int calculate(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }

        int origI = i;
        int origK = k;

        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }

        int res = (k + 1) * (k + 1) + calculate(boxes, i + 1, j, 0, dp);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, calculate(boxes, i + 1, m - 1, 0, dp) 
                                  + calculate(boxes, m, j, k + 1, dp));
            }
        }

        dp[origI][j][origK] = res;
        return res;
    }
}
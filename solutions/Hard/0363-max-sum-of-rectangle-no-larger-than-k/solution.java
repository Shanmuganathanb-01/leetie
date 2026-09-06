// ──────────────────────────────────────────────────
// Problem  : 363. Max Sum of Rectangle No Larger Than K
// Difficulty: Hard
// Tags     : Array, Binary Search, Matrix, Prefix Sum, Ordered Set
// Link     : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
// Runtime  : 358 ms (beats 36%)
// Memory   : 46416000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }

                java.util.TreeSet<Integer> set = new java.util.TreeSet<>();
                set.add(0);
                int currentSum = 0;

                for (int sum : rowSum) {
                    currentSum += sum;
                    Integer ceiling = set.ceiling(currentSum - k);
                    if (ceiling != null) {
                        maxSum = Math.max(maxSum, currentSum - ceiling);
                    }
                    set.add(currentSum);
                }
            }
        }
        return maxSum;
    }
}
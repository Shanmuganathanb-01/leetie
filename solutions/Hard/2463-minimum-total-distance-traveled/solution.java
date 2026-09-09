// ──────────────────────────────────────────────────
// Problem  : 2463. Minimum Total Distance Traveled
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/minimum-total-distance-traveled/
// Runtime  : 52 ms (beats 28%)
// Memory   : 72728000 (beats 22%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int k = 0; k < f[1]; k++) {
                factoryPositions.add(f[0]);
            }
        }

        int m = robot.size();
        int n = factoryPositions.size();
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][n] = Long.MAX_VALUE / 2;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                long take = Math.abs((long) robot.get(i) - factoryPositions.get(j)) + dp[i + 1][j + 1];
                long skip = dp[i][j + 1];
                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[0][0];
    }
}
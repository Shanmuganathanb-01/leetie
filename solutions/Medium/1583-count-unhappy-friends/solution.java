// ──────────────────────────────────────────────────
// Problem  : 1583. Count Unhappy Friends
// Difficulty: Medium
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/count-unhappy-friends/
// Runtime  : 2 ms (beats 96%)
// Memory   : 65728000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] match = new int[n];
        for (int[] p : pairs) {
            match[p[0]] = p[1];
            match[p[1]] = p[0];
        }

        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }

        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int yRank = rank[x][y];
            boolean isUnhappy = false;

            for (int i = 0; i < yRank; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (rank[u][x] < rank[u][v]) {
                    isUnhappy = true;
                    break;
                }
            }

            if (isUnhappy) {
                unhappyCount++;
            }
        }

        return unhappyCount;
    }
}
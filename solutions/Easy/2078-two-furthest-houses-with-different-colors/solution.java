// ──────────────────────────────────────────────────
// Problem  : 2078. Two Furthest Houses With Different Colors
// Difficulty: Easy
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/two-furthest-houses-with-different-colors/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42868000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
                break;
            }
        }

        return maxDist;
    }
}
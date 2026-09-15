// ──────────────────────────────────────────────────
// Problem  : 1503. Last Moment Before All Ants Fall Out of a Plank
// Difficulty: Medium
// Tags     : Array, Brainteaser, Simulation
// Link     : https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46952000 (beats 54%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }
        return maxTime;
    }
}
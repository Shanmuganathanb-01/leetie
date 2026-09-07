// ──────────────────────────────────────────────────
// Problem  : 495. Teemo Attacking
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/teemo-attacking/
// Runtime  : 4 ms (beats 8%)
// Memory   : 48596000 (beats 7%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        
        int totalDuration = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalDuration += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        totalDuration += duration;
        
        return totalDuration;
    }
}
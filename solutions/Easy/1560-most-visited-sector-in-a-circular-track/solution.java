// ──────────────────────────────────────────────────
// Problem  : 1560. Most Visited Sector in  a Circular Track
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44832000 (beats 7%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
            for (int i = start; i <= n; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
}
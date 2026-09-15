// ──────────────────────────────────────────────────
// Problem  : 1094. Car Pooling
// Difficulty: Medium
// Tags     : Array, Sorting, Heap (Priority Queue), Simulation, Prefix Sum
// Link     : https://leetcode.com/problems/car-pooling/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46332000 (beats 43%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        
        int currentPassengers = 0;
        for (int passengers : timestamp) {
            currentPassengers += passengers;
            if (currentPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
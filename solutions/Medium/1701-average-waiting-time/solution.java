// ──────────────────────────────────────────────────
// Problem  : 1701. Average Waiting Time
// Difficulty: Medium
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/average-waiting-time/
// Runtime  : 0 ms (beats 0%)
// Memory   : 45676000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0;
        long currentTime = 0;
        
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            
            if (currentTime < arrival) {
                currentTime = arrival;
            }
            
            currentTime += time;
            totalWait += (currentTime - arrival);
        }
        
        return (double) totalWait / customers.length;
    }
}
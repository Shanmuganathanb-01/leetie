// ──────────────────────────────────────────────────
// Problem  : 1535. Find the Winner of an Array Game
// Difficulty: Medium
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/find-the-winner-of-an-array-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 66924000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getWinner(int[] arr, int k) {
        int currentWinner = arr[0];
        int streak = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (currentWinner > arr[i]) {
                streak++;
            } else {
                currentWinner = arr[i];
                streak = 1;
            }
            
            if (streak == k) {
                return currentWinner;
            }
        }
        
        return currentWinner;
    }
}
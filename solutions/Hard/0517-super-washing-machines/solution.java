// ──────────────────────────────────────────────────
// Problem  : 517. Super Washing Machines
// Difficulty: Hard
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/super-washing-machines/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42452000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMinMoves(int[] machines) {
        int totalDresses = 0;
        for (int m : machines) {
            totalDresses += m;
        }
        
        int n = machines.length;
        if (totalDresses % n != 0) {
            return -1;
        }
        
        int target = totalDresses / n;
        int maxMoves = 0;
        int balance = 0;
        
        for (int m : machines) {
            balance += m - target;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(balance), m - target));
        }
        
        return maxMoves;
    }
}
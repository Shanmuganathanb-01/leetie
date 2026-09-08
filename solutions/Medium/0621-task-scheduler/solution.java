// ──────────────────────────────────────────────────
// Problem  : 621. Task Scheduler
// Difficulty: Medium
// Tags     : Array, Hash Table, Greedy, Sorting, Heap (Priority Queue), Counting
// Link     : https://leetcode.com/problems/task-scheduler/
// Runtime  : 3 ms (beats 79%)
// Memory   : 48288000 (beats 52%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        java.util.Arrays.sort(count);
        int maxFreq = count[25];
        int idleSlots = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, count[i]);
        }
        
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 1700. Number of Students Unable to Eat Lunch
// Difficulty: Easy
// Tags     : Array, Stack, Queue, Simulation
// Link     : https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43272000 (beats 62%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        
        for (int i = 0; i < sandwiches.length; i++) {
            if (count[sandwiches[i]] > 0) {
                count[sandwiches[i]]--;
            } else {
                return sandwiches.length - i;
            }
        }
        
        return 0;
    }
}
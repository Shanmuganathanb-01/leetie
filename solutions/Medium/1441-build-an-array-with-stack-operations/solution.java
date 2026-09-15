// ──────────────────────────────────────────────────
// Problem  : 1441. Build an Array With Stack Operations
// Difficulty: Medium
// Tags     : Array, Stack, Simulation
// Link     : https://leetcode.com/problems/build-an-array-with-stack-operations/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42992000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int current = 1;
        
        for (int num : target) {
            while (current < num) {
                result.add("Push");
                result.add("Pop");
                current++;
            }
            result.add("Push");
            current++;
        }
        
        return result;
    }
}
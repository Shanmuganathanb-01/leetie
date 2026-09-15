// ──────────────────────────────────────────────────
// Problem  : 1404. Number of Steps to Reduce a Number in Binary Representation to One
// Difficulty: Medium
// Tags     : String, Bit Manipulation, Simulation
// Link     : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42716000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;
            if (bit % 2 == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }
        
        return steps + carry;
    }
}
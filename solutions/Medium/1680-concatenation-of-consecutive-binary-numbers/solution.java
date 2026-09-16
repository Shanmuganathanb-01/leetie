// ──────────────────────────────────────────────────
// Problem  : 1680. Concatenation of Consecutive Binary Numbers
// Difficulty: Medium
// Tags     : Math, Bit Manipulation, Simulation
// Link     : https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42192000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        long mod = 1_000_000_007;
        int length = 0;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                length++;
            }
            result = ((result << length) + i) % mod;
        }
        
        return (int) result;
    }
}
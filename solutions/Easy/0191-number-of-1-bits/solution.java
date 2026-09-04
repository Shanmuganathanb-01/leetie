// ──────────────────────────────────────────────────
// Problem  : 191. Number of 1 Bits
// Difficulty: Easy
// Tags     : Divide and Conquer, Bit Manipulation
// Link     : https://leetcode.com/problems/number-of-1-bits/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42588000 (beats 28%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
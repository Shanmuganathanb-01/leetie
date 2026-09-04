// ──────────────────────────────────────────────────
// Problem  : 190. Reverse Bits
// Difficulty: Easy
// Tags     : Divide and Conquer, Bit Manipulation
// Link     : https://leetcode.com/problems/reverse-bits/
// Runtime  : 1 ms (beats 60%)
// Memory   : 42572000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
}
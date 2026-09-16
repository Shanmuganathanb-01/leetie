// ──────────────────────────────────────────────────
// Problem  : 1545. Find Kth Bit in Nth Binary String
// Difficulty: Medium
// Tags     : String, Recursion, Simulation
// Link     : https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42240000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int mid = (1 << (n - 1));
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char correspondingBit = findKthBit(n - 1, 2 * mid - k);
            return correspondingBit == '0' ? '1' : '0';
        }
    }
}
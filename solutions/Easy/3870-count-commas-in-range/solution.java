// ──────────────────────────────────────────────────
// Problem  : 3870. Count Commas in Range
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/count-commas-in-range/
// Runtime  : 1 ms (beats 84%)
// Memory   : 42816000 (beats 8%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        } else if (n <= 99999) {
            return n - 999;
        } else {
            return 99000 + (n - 100000 + 1);
        }
    }
}
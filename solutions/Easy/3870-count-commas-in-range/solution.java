// ──────────────────────────────────────────────────
// Problem  : 3870. Count Commas in Range
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/count-commas-in-range/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42092000 (beats 0%)
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
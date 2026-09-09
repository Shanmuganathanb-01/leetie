// ──────────────────────────────────────────────────
// Problem  : 3871. Count Commas in Range II
// Difficulty: Medium
// Tags     : Math
// Link     : https://leetcode.com/problems/count-commas-in-range-ii/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42708000 (beats 37%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {
            long end = Math.min(n, (start * 1000) - 1);
            totalCommas += (end - start + 1) * commas;
            start *= 1000;
            commas++;
        }

        return totalCommas;
    }
}
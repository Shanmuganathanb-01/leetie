// ──────────────────────────────────────────────────
// Problem  : 3783. Mirror Distance of an Integer
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/mirror-distance-of-an-integer/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42024000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int temp = n;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return Math.abs(n - rev);
    }
}
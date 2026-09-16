// ──────────────────────────────────────────────────
// Problem  : 1621. Number of Sets of K Non-Overlapping Line Segments
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Combinatorics, Prefix Sum
// Link     : https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
// Runtime  : 1 ms (beats 95%)
// Memory   : 42032000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfSets(int n, int k) {
        long mod = 1_000_000_007;
        long n_plus_k = n + k;
        long num = 1;
        long den = 1;
        int r = 2 * k;
        
        if (n_plus_k - 1 < r) return 0;
        
        for (int i = 0; i < r; i++) {
            num = (num * (n_plus_k - 1 - i)) % mod;
            den = (den * (i + 1)) % mod;
        }
        
        long invDen = power(den, mod - 2, mod);
        return (int)((num * invDen) % mod);
    }
    
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
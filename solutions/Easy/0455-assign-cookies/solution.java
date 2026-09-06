// ──────────────────────────────────────────────────
// Problem  : 455. Assign Cookies
// Difficulty: Easy
// Tags     : Array, Two Pointers, Greedy, Sorting, Quicksort
// Link     : https://leetcode.com/problems/assign-cookies/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42236000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        
        int child = 0;
        int cookie = 0;
        
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }
        
        return child;
    }
}
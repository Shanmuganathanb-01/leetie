// ──────────────────────────────────────────────────
// Problem  : 455. Assign Cookies
// Difficulty: Easy
// Tags     : Array, Two Pointers, Greedy, Sorting, Quicksort
// Link     : https://leetcode.com/problems/assign-cookies/
// Runtime  : 15 ms (beats 60%)
// Memory   : 51420000 (beats 56%)
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
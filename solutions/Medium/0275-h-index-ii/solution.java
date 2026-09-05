// ──────────────────────────────────────────────────
// Problem  : 275. H-Index II
// Difficulty: Medium
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/h-index-ii/
// Runtime  : 2 ms (beats 12%)
// Memory   : 49912000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        
        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += count[i];
            if (papers >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
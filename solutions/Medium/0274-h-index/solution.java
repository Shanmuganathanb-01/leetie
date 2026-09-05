// ──────────────────────────────────────────────────
// Problem  : 274. H-Index
// Difficulty: Medium
// Tags     : Array, Sorting, Counting Sort
// Link     : https://leetcode.com/problems/h-index/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43236000 (beats 84%)
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
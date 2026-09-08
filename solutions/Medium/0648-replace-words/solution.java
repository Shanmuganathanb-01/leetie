// ──────────────────────────────────────────────────
// Problem  : 648. Replace Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie
// Link     : https://leetcode.com/problems/replace-words/
// Runtime  : 9 ms (beats 94%)
// Memory   : 46940000 (beats 66%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findLongestChain(int[][] pairs) {
        java.util.Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int currentEnd = Integer.MIN_VALUE;
        
        for (int[] p : pairs) {
            if (p[0] > currentEnd) {
                count++;
                currentEnd = p[1];
            }
        }
        
        return count;
    }
}
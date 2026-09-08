// ──────────────────────────────────────────────────
// Problem  : 646. Maximum Length of Pair Chain
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy, Sorting, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/maximum-length-of-pair-chain/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42768000 (beats 0%)
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
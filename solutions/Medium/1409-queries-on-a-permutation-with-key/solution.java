// ──────────────────────────────────────────────────
// Problem  : 1409. Queries on a Permutation With Key
// Difficulty: Medium
// Tags     : Array, Binary Indexed Tree, Simulation, Sqrt Decomposition
// Link     : https://leetcode.com/problems/queries-on-a-permutation-with-key/
// Runtime  : 3 ms (beats 94%)
// Memory   : 44036000 (beats 80%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i];
            int idx = 0;
            
            for (int j = 0; j < m; j++) {
                if (p[j] == val) {
                    idx = j;
                    break;
                }
            }
            
            res[i] = idx;
            
            for (int j = idx; j > 0; j--) {
                p[j] = p[j - 1];
            }
            p[0] = val;
        }
        
        return res;
    }
}
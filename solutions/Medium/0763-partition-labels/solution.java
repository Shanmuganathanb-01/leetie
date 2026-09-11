// ──────────────────────────────────────────────────
// Problem  : 763. Partition Labels
// Difficulty: Medium
// Tags     : Hash Table, Two Pointers, String, Greedy
// Link     : https://leetcode.com/problems/partition-labels/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42556000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int anchor = 0, j = 0;
        
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        
        return result;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 624. Maximum Distance in Arrays
// Difficulty: Medium
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/maximum-distance-in-arrays/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42028000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int currMin = curr.get(0);
            int currMax = curr.get(curr.size() - 1);
            
            res = Math.max(res, Math.max(Math.abs(currMax - min), Math.abs(max - currMin)));
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        
        return res;
    }
}
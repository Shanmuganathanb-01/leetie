// ──────────────────────────────────────────────────
// Problem  : 3741. Minimum Distance Between Three Equal Elements II
// Difficulty: Medium
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/
// Runtime  : 112 ms (beats 42%)
// Memory   : 274664000 (beats 39%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(i + 1);
                    int idx3 = indices.get(i + 2);
                    int dist = Math.abs(idx1 - idx2) + Math.abs(idx2 - idx3) + Math.abs(idx3 - idx1);
                    minDistance = Math.min(minDistance, dist);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
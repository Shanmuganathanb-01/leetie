// ──────────────────────────────────────────────────
// Problem  : 594. Longest Harmonious Subsequence
// Difficulty: Easy
// Tags     : Array, Hash Table, Sliding Window, Sorting, Counting
// Link     : https://leetcode.com/problems/longest-harmonious-subsequence/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42356000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, countMap.get(key) + countMap.get(key + 1));
            }
        }

        return maxLength;
    }
}
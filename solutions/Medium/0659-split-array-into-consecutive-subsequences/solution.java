// ──────────────────────────────────────────────────
// Problem  : 659. Split Array into Consecutive Subsequences
// Difficulty: Medium
// Tags     : Array, Hash Table, Greedy, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/split-array-into-consecutive-subsequences/
// Runtime  : 29 ms (beats 25%)
// Memory   : 48504000 (beats 31%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            
            if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            
            freq.put(num, freq.get(num) - 1);
        }
        
        return true;
    }
}
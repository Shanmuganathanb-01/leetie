// ──────────────────────────────────────────────────
// Problem  : 403. Frog Jump
// Difficulty: Hard
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/frog-jump/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42704000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        
        int n = stones.length;
        java.util.Map<Integer, java.util.Set<Integer>> map = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new java.util.HashSet<>());
        }
        map.get(stones[0]).add(0);
        
        for (int i = 0; i < n; i++) {
            int stone = stones[i];
            for (int k : map.get(stone)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        
        return !map.get(stones[n - 1]).isEmpty();
    }
}
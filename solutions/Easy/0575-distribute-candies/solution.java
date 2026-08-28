// ──────────────────────────────────────────────────
// Problem  : 575. Distribute Candies
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/distribute-candies/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42796000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueTypes = new HashSet<>();
        
        for (int type : candyType) {
            uniqueTypes.add(type);
        }

        return Math.min(uniqueTypes.size(), candyType.length / 2);
    }
}
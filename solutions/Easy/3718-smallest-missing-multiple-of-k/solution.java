// ──────────────────────────────────────────────────
// Problem  : 3718. Smallest Missing Multiple of K
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/smallest-missing-multiple-of-k/
// Runtime  : 2 ms (beats 68%)
// Memory   : 45264000 (beats 62%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int multiple = k;
        while (numSet.contains(multiple)) {
            multiple += k;
        }
        
        return multiple;
    }
}
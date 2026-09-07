// ──────────────────────────────────────────────────
// Problem  : 475. Heaters
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/heaters/
// Runtime  : 17 ms (beats 94%)
// Memory   : 47928000 (beats 48%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        int i = 0;
        
        for (int house : houses) {
            while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            radius = Math.max(radius, Math.abs(heaters[i] - house));
        }
        
        return radius;
    }
}
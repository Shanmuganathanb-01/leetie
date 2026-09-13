// ──────────────────────────────────────────────────
// Problem  : 717. 1-bit and 2-bit Characters
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/1-bit-and-2-bit-characters/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44476000 (beats 47%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        
        return i == n - 1;
    }
}
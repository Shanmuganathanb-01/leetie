// ──────────────────────────────────────────────────
// Problem  : 260. Single Number III
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/single-number-iii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 43120000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }
        
        int diffBit = xorAll & -xorAll;
        int[] result = new int[2];
        
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 393. UTF-8 Validation
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/utf-8-validation/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42452000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;
        
        for (int num : data) {
            int byteVal = num & 0xFF;
            
            if (remainingBytes == 0) {
                if ((byteVal >> 7) == 0) {
                    continue;
                } else if ((byteVal >> 5) == 06) {
                    remainingBytes = 1;
                } else if ((byteVal >> 4) == 016) {
                    remainingBytes = 2;
                } else if ((byteVal >> 3) == 036) {
                    remainingBytes = 3;
                } else {
                    return false;
                }
            } else {
                if ((byteVal >> 6) != 2) {
                    return false;
                }
                remainingBytes--;
            }
        }
        
        return remainingBytes == 0;
    }
}
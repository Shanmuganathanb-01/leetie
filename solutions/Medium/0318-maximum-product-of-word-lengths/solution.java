// ──────────────────────────────────────────────────
// Problem  : 318. Maximum Product of Word Lengths
// Difficulty: Medium
// Tags     : Array, String, Bit Manipulation
// Link     : https://leetcode.com/problems/maximum-product-of-word-lengths/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41920000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];
        
        for (int i = 0; i < n; i++) {
            lengths[i] = words[i].length();
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            masks[i] = mask;
        }
        
        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lengths[i] * lengths[j]);
                }
            }
        }
        
        return maxProd;
    }
}
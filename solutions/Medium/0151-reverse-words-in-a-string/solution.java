// ──────────────────────────────────────────────────
// Problem  : 151. Reverse Words in a String
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-words-in-a-string/
// Runtime  : 7 ms (beats 63%)
// Memory   : 44272000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
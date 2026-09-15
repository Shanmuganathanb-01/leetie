// ──────────────────────────────────────────────────
// Problem  : 1324. Print Words Vertically
// Difficulty: Medium
// Tags     : Array, String, Simulation
// Link     : https://leetcode.com/problems/print-words-vertically/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42904000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            
            int end = sb.length() - 1;
            while (end >= 0 && sb.charAt(end) == ' ') {
                end--;
            }
            result.add(sb.substring(0, end + 1));
        }
        
        return result;
    }
}
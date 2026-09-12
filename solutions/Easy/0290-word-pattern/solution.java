// ──────────────────────────────────────────────────
// Problem  : 290. Word Pattern
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/word-pattern/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42668000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        
        java.util.Map<Character, String> map = new java.util.HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(c, word);
            }
        }
        
        return true;
    }
}
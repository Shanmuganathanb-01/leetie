// ──────────────────────────────────────────────────
// Problem  : 720. Longest Word in Dictionary
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie, Sorting
// Link     : https://leetcode.com/problems/longest-word-in-dictionary/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42544000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String longestWord(String[] words) {
        java.util.Arrays.sort(words);
        java.util.Set<String> built = new java.util.HashSet<>();
        String res = "";
        
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                if (w.length() > res.length()) {
                    res = w;
                }
                built.add(w);
            }
        }
        
        return res;
    }
}
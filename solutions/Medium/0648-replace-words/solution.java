// ──────────────────────────────────────────────────
// Problem  : 648. Replace Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie
// Link     : https://leetcode.com/problems/replace-words/
// Runtime  : 702 ms (beats 14%)
// Memory   : 59140000 (beats 71%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            String replacement = word;
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (dictSet.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(replacement);
        }
        
        return result.toString();
    }
}
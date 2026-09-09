// ──────────────────────────────────────────────────
// Problem  : 2452. Words Within Two Edits of Dictionary
// Difficulty: Medium
// Tags     : Array, String, Trie
// Link     : https://leetcode.com/problems/words-within-two-edits-of-dictionary/
// Runtime  : 12 ms (beats 25%)
// Memory   : 46552000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String q : queries) {
            boolean matched = false;
            for (String d : dictionary) {
                int diff = 0;
                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        diff++;
                    }
                }
                if (diff <= 2) {
                    matched = true;
                    break;
                }
            }
            if (matched) {
                result.add(q);
            }
        }
        
        return result;
    }
}
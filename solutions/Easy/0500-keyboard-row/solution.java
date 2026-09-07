// ──────────────────────────────────────────────────
// Problem  : 500. Keyboard Row
// Difficulty: Easy
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/keyboard-row/
// Runtime  : 1 ms (beats 32%)
// Memory   : 42480000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                map.put(c, i);
                map.put(Character.toUpperCase(c), i);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) continue;
            int rowIndex = map.get(word.charAt(0));
            boolean isValid = true;
            for (int i = 1; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != rowIndex) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
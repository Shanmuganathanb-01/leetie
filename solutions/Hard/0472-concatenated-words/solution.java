// ──────────────────────────────────────────────────
// Problem  : 472. Concatenated Words
// Difficulty: Hard
// Tags     : Array, String, Dynamic Programming, Depth-First Search, Trie, Sorting
// Link     : https://leetcode.com/problems/concatenated-words/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42532000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            wordSet.remove(word);
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        
        return result;
    }
    
    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) return false;
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
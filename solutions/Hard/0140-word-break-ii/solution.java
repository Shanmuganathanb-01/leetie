// ──────────────────────────────────────────────────
// Problem  : 140. Word Break II
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Dynamic Programming, Backtracking, Trie, Memoization
// Link     : https://leetcode.com/problems/word-break-ii/
// Runtime  : 3 ms (beats 57%)
// Memory   : 49320000 (beats 5%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    java.util.Map<Integer, List<String>> memo = new java.util.HashMap<>();
    java.util.Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new java.util.HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private List<String> dfs(String s, int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> validSentences = new java.util.ArrayList<>();
        if (start == s.length()) {
            validSentences.add("");
            return validSentences;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> subSentences = dfs(s, end);
                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        validSentences.add(word);
                    } else {
                        validSentences.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(start, validSentences);
        return validSentences;
    }
}
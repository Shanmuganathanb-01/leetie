// ──────────────────────────────────────────────────
// Problem  : 139. Word Break
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Dynamic Programming, Trie, Memoization, Brute-Force Search
// Link     : https://leetcode.com/problems/word-break/
// Runtime  : 8 ms (beats 49%)
// Memory   : 45996000 (beats 61%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        java.util.Set<String> wordSet = new java.util.HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
// ──────────────────────────────────────────────────
// Problem  : 2472. Maximum Number of Non-overlapping Palindrome Substrings
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
// Runtime  : 52 ms (beats 49%)
// Memory   : 42896000 (beats 79%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        Integer[] memo = new Integer[n];
        return dp(0, s, k, memo);
    }
    
    private int dp(int i, String s, int k, Integer[] memo) {
        if (i >= s.length()) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        
        int max = dp(i + 1, s, k, memo);
        
        for (int j = i + k - 1; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                max = Math.max(max, 1 + dp(j + 1, s, k, memo));
                break;
            }
        }
        
        return memo[i] = max;
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
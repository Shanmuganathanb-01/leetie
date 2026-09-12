// ──────────────────────────────────────────────────
// Problem  : 214. Shortest Palindrome
// Difficulty: Hard
// Tags     : String, Rolling Hash, String Matching, Hash Function, Manacher, Z Algorithm, Knuth–Morris–Pratt Algorithm
// Link     : https://leetcode.com/problems/shortest-palindrome/
// Runtime  : 9 ms (beats 37%)
// Memory   : 47036000 (beats 33%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;
        int[] lps = new int[temp.length()];
        
        for (int i = 1; i < temp.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = lps[j - 1];
            }
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        
        int longestPalindromicPrefix = lps[temp.length() - 1];
        String suffixToAdd = s.substring(longestPalindromicPrefix);
        
        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 2472. Maximum Number of Non-overlapping Palindrome Substrings
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42668000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;
        
        while (i < n) {
            boolean found = false;
            for (int len = k; len <= k + 1; len++) {
                if (i + len <= n && isPalindrome(s, i, i + len - 1)) {
                    count++;
                    i += len;
                    found = true;
                    break;
                }
            }
            if (!found) {
                int len = k + 2;
                while (i + len <= n) {
                    if (isPalindrome(s, i, i + len - 1)) {
                        count++;
                        i += len;
                        found = true;
                        break;
                    }
                    len++;
                }
            }
            if (!found) {
                i++;
            }
        }
        return count;
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
// ──────────────────────────────────────────────────
// Problem  : 680. Valid Palindrome II
// Difficulty: Easy
// Tags     : Two Pointers, String, Greedy
// Link     : https://leetcode.com/problems/valid-palindrome-ii/
// Runtime  : 4 ms (beats 99%)
// Memory   : 47620000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindromeRange(s, left + 1, right) || isPalindromeRange(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
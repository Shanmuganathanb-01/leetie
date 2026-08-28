// ──────────────────────────────────────────────────
// Problem  : 3734. Lexicographically Smallest Palindromic Permutation Greater Than Target
// Difficulty: Hard
// Tags     : Two Pointers, String, Enumeration
// Link     : https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/
// Runtime  : 6 ms (beats 76%)
// Memory   : 46996000 (beats 57%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        int midCharIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midCharIdx = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int m = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        // Try prefix match first
        int[] curHalf = halfCount.clone();
        boolean canMatchPrefix = true;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tChar = target.charAt(i) - 'a';
            if (curHalf[tChar] > 0) {
                curHalf[tChar]--;
                prefix.append(target.charAt(i));
            } else {
                canMatchPrefix = false;
                break;
            }
        }

        if (canMatchPrefix) {
            char midChar = (n % 2 != 0) ? (char) ('a' + midCharIdx) : 0;
            String candidate = constructPalindrome(prefix.toString(), midChar, n % 2 != 0);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Find the rightmost position in the first half to increment
        for (int i = m - 1; i >= 0; i--) {
            // Reconstruct halfCount availability up to position i
            int[] avail = halfCount.clone();
            for (int k = 0; k < i; k++) {
                avail[target.charAt(k) - 'a']--;
            }

            // Check if prefix target[0...i-1] was possible
            boolean validPrefix = true;
            for (int k = 0; k < 26; k++) {
                if (avail[k] < 0) {
                    validPrefix = false;
                    break;
                }
            }
            if (!validPrefix) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (avail[c] > 0) {
                    avail[c]--;
                    
                    StringBuilder firstHalf = new StringBuilder(target.substring(0, i));
                    firstHalf.append((char) ('a' + c));

                    // Fill remaining half positions greedily with smallest chars
                    for (int ch = 0; ch < 26; ch++) {
                        while (avail[ch] > 0) {
                            firstHalf.append((char) ('a' + ch));
                            avail[ch]--;
                        }
                    }

                    char midChar = (n % 2 != 0) ? (char) ('a' + midCharIdx) : 0;
                    return constructPalindrome(firstHalf.toString(), midChar, n % 2 != 0);
                }
            }
        }

        return "";
    }

    private String constructPalindrome(String half, char midChar, boolean isOdd) {
        StringBuilder sb = new StringBuilder(half);
        if (isOdd) {
            sb.append(midChar);
        }
        for (int i = half.length() - 1; i >= 0; i--) {
            sb.append(half.charAt(i));
        }
        return sb.toString();
    }
}
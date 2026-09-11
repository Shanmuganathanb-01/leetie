// ──────────────────────────────────────────────────
// Problem  : 678. Valid Parenthesis String
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Stack, Greedy, Bracket Sequences
// Link     : https://leetcode.com/problems/valid-parenthesis-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43044000 (beats 12%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin = Math.max(0, cmin - 1);
                cmax--;
            } else {
                cmin = Math.max(0, cmin - 1);
                cmax++;
            }
            if (cmax < 0) {
                return false;
            }
        }
        return cmin == 0;
    }
}
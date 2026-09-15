// ──────────────────────────────────────────────────
// Problem  : 844. Backspace String Compare
// Difficulty: Easy
// Tags     : Two Pointers, String, Stack, Simulation
// Link     : https://leetcode.com/problems/backspace-string-compare/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42416000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
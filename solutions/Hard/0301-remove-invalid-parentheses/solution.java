// ──────────────────────────────────────────────────
// Problem  : 301. Remove Invalid Parentheses
// Difficulty: Hard
// Tags     : String, Backtracking, Breadth-First Search
// Link     : https://leetcode.com/problems/remove-invalid-parentheses/
// Runtime  : 118 ms (beats 28%)
// Memory   : 43872000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmLeft = 0, rmRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rmLeft++;
            } else if (c == ')') {
                if (rmLeft > 0) {
                    rmLeft--;
                } else {
                    rmRight++;
                }
            }
        }
        
        java.util.Set<String> res = new java.util.HashSet<>();
        dfs(s, 0, rmLeft, rmRight, 0, new StringBuilder(), res);
        return new java.util.ArrayList<>(res);
    }
    
    private void dfs(String s, int i, int rmLeft, int rmRight, int open, StringBuilder sb, java.util.Set<String> res) {
        if (i == s.length()) {
            if (rmLeft == 0 && rmRight == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        
        char c = s.charAt(i);
        int len = sb.length();
        
        if (c == '(' && rmLeft > 0) {
            dfs(s, i + 1, rmLeft - 1, rmRight, open, sb, res);
        }
        if (c == ')' && rmRight > 0) {
            dfs(s, i + 1, rmLeft, rmRight - 1, open, sb, res);
        }
        
        sb.append(c);
        if (c == '(') {
            dfs(s, i + 1, rmLeft, rmRight, open + 1, sb, res);
        } else if (c == ')') {
            if (open > 0) {
                dfs(s, i + 1, rmLeft, rmRight, open - 1, sb, res);
            }
        } else {
            dfs(s, i + 1, rmLeft, rmRight, open, sb, res);
        }
        sb.setLength(len);
    }
}
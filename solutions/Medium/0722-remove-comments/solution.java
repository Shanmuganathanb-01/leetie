// ──────────────────────────────────────────────────
// Problem  : 722. Remove Comments
// Difficulty: Medium
// Tags     : Array, String
// Link     : https://leetcode.com/problems/remove-comments/
// Runtime  : 1 ms (beats 74%)
// Memory   : 43232000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        
        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (!inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(line.charAt(i));
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                }
                i++;
            }
            
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
}
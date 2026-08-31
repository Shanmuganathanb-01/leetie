// ──────────────────────────────────────────────────
// Problem  : 2075. Decode the Slanted Ciphertext
// Difficulty: Medium
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/decode-the-slanted-ciphertext/
// Runtime  : 17 ms (beats 98%)
// Memory   : 54884000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty() || rows == 1) {
            return encodedText;
        }
        
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (c + r < cols) {
                    sb.append(encodedText.charAt(r * cols + c + r));
                } else {
                    break;
                }
            }
        }
        
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        
        return sb.substring(0, end + 1);
    }
}
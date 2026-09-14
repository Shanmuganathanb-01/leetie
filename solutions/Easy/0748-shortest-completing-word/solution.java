// ──────────────────────────────────────────────────
// Problem  : 748. Shortest Completing Word
// Difficulty: Easy
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/shortest-completing-word/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42600000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = getCharCounts(licensePlate);
        String ans = "";
        
        for (String word : words) {
            if ((ans.isEmpty() || word.length() < ans.length()) && isCompleting(getCharCounts(word), target)) {
                ans = word;
            }
        }
        
        return ans;
    }
    
    private int[] getCharCounts(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                counts[Character.toLowerCase(c) - 'a']++;
            }
        }
        return counts;
    }
    
    private boolean isCompleting(int[] wordCounts, int[] targetCounts) {
        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] < targetCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
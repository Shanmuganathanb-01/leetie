// ──────────────────────────────────────────────────
// Problem  : 744. Find Smallest Letter Greater Than Target
// Difficulty: Easy
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46548000 (beats 15%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left == letters.length ? letters[0] : letters[left];
    }
}
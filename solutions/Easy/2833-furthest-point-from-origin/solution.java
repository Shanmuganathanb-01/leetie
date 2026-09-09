// ──────────────────────────────────────────────────
// Problem  : 2833. Furthest Point From Origin
// Difficulty: Easy
// Tags     : String, Counting
// Link     : https://leetcode.com/problems/furthest-point-from-origin/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42584000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countUnderscore = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            } else {
                countUnderscore++;
            }
        }

        return Math.abs(countL - countR) + countUnderscore;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 605. Can Place Flowers
// Difficulty: Easy
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/can-place-flowers/
// Runtime  : 1 ms (beats 99%)
// Memory   : 48032000 (beats 5%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return n <= 0;
    }
}
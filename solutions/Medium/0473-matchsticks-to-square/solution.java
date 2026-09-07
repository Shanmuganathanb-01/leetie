// ──────────────────────────────────────────────────
// Problem  : 473. Matchsticks to Square
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Bitmask
// Link     : https://leetcode.com/problems/matchsticks-to-square/
// Runtime  : 7 ms (beats 80%)
// Memory   : 42892000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        
        if (sum % 4 != 0 || matchsticks.length < 4) {
            return false;
        }
        
        int target = sum / 4;
        Integer[] matchsticksArr = new Integer[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++) {
            matchsticksArr[i] = matchsticks[i];
        }
        
        Arrays.sort(matchsticksArr, Collections.reverseOrder());
        
        int[] sides = new int[4];
        return dfs(matchsticksArr, 0, sides, target);
    }
    
    private boolean dfs(Integer[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        
        int match = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + match <= target) {
                sides[i] += match;
                if (dfs(matchsticks, index + 1, sides, target)) {
                    return true;
                }
                sides[i] -= match;
            }
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}
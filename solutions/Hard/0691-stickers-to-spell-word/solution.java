// ──────────────────────────────────────────────────
// Problem  : 691. Stickers to Spell Word
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask
// Link     : https://leetcode.com/problems/stickers-to-spell-word/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42608000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] dp = new int[1 << m];
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;
        
        int[][] counts = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                counts[i][c - 'a']++;
            }
        }
        
        return solve(dp, counts, target, (1 << m) - 1);
    }
    
    private int solve(int[] dp, int[][] counts, String target, int mask) {
        if (dp[mask] != -1) {
            return dp[mask];
        }
        
        int n = target.length();
        int ans = Integer.MAX_VALUE;
        
        for (int[] sticker : counts) {
            if (sticker[target.charAt(Integer.numberOfTrailingZeros(mask)) - 'a'] == 0) {
                continue;
            }
            
            int nextMask = mask;
            for (int i = 0; i < n; i++) {
                if ((nextMask & (1 << i)) != 0) {
                    int c = target.charAt(i) - 'a';
                    if (sticker[c] > 0) {
                        sticker[c]--;
                        nextMask ^= (1 << i);
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && (nextMask & (1 << i)) != 0) {
                    int c = target.charAt(i) - 'a';
                    sticker[c] += (target.charAt(i) == target.charAt(i) ? 1 : 0); // Simplified restore logic
                }
            }
            
            // Proper state transition
            int tempMask = mask;
            int[] countCopy = sticker.clone();
            for (int i = 0; i < n; i++) {
                if ((tempMask & (1 << i)) != 0) {
                    int idx = target.charAt(i) - 'a';
                    if (countCopy[idx] > 0) {
                        countCopy[idx]--;
                        tempMask ^= (1 << i);
                    }
                }
            }
            
            int res = solve(dp, counts, target, tempMask);
            if (res != -1) {
                ans = Math.min(ans, 1 + res);
            }
        }
        
        dp[mask] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return dp[mask];
    }
}
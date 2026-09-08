// ──────────────────────────────────────────────────
// Problem  : 691. Stickers to Spell Word
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask
// Link     : https://leetcode.com/problems/stickers-to-spell-word/
// Runtime  : 7 ms (beats 99%)
// Memory   : 46992000 (beats 50%)
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
        
        int ans = solve(dp, counts, target, (1 << m) - 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int solve(int[] dp, int[][] counts, String target, int mask) {
        if (dp[mask] != -1) {
            return dp[mask];
        }
        
        int n = target.length();
        int ans = Integer.MAX_VALUE;
        int firstUnmatched = Integer.numberOfTrailingZeros(mask);
        
        for (int[] sticker : counts) {
            if (sticker[target.charAt(firstUnmatched) - 'a'] == 0) {
                continue;
            }
            
            int nextMask = mask;
            int[] stickerCopy = sticker.clone();
            
            for (int i = 0; i < n; i++) {
                if ((nextMask & (1 << i)) != 0) {
                    int c = target.charAt(i) - 'a';
                    if (stickerCopy[c] > 0) {
                        stickerCopy[c]--;
                        nextMask ^= (1 << i);
                    }
                }
            }
            
            int res = solve(dp, counts, target, nextMask);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + res);
            }
        }
        
        dp[mask] = ans;
        return dp[mask];
    }
}
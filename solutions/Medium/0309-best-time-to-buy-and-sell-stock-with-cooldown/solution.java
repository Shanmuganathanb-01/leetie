// ──────────────────────────────────────────────────
// Problem  : 309. Best Time to Buy and Sell Stock with Cooldown
// Difficulty: Medium
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43504000 (beats 48%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] reset = new int[n];
        
        hold[0] = -prices[0];
        sold[0] = 0;
        reset[0] = 0;
        
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], reset[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            reset[i] = Math.max(reset[i - 1], sold[i - 1]);
        }
        
        return Math.max(sold[n - 1], reset[n - 1]);
    }
}
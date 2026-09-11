// ──────────────────────────────────────────────────
// Problem  : 714. Best Time to Buy and Sell Stock with Transaction Fee
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Runtime  : 5 ms (beats 82%)
// Memory   : 65632000 (beats 64%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        
        return cash;
    }
}
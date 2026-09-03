// ──────────────────────────────────────────────────
// Problem  : 122. Best Time to Buy and Sell Stock II
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42316000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}
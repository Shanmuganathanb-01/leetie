// ──────────────────────────────────────────────────
// Problem  : 638. Shopping Offers
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask, Knapsack Problem, Complete Knapsack
// Link     : https://leetcode.com/problems/shopping-offers/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42448000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new java.util.HashMap<>());
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        
        int minCost = directPurchaseCost(price, needs);
        
        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = new ArrayList<>(needs);
            boolean isValid = true;
            
            for (int i = 0; i < needs.size(); i++) {
                int diff = nextNeeds.get(i) - offer.get(i);
                if (diff < 0) {
                    isValid = false;
                    break;
                }
                nextNeeds.set(i, diff);
            }
            
            if (isValid) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, nextNeeds, memo));
            }
        }
        
        memo.put(needs, minCost);
        return minCost;
    }
    
    private int directPurchaseCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 1599. Maximum Profit of Operating a Centennial Wheel
// Difficulty: Medium
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42432000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = 0;
        int currentProfit = 0;
        int operations = 0;
        int maxOperations = -1;
        int waitingCustomers = 0;
        int i = 0;
        
        while (i < customers.length || waitingCustomers > 0) {
            if (i < customers.length) {
                waitingCustomers += customers[i];
            }
            
            int boarding = Math.min(4, waitingCustomers);
            waitingCustomers -= boarding;
            operations++;
            
            currentProfit += boarding * boardingCost - runningCost;
            
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxOperations = operations;
            }
            
            i++;
        }
        
        return maxOperations;
    }
}
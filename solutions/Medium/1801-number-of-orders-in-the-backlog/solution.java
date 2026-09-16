// ──────────────────────────────────────────────────
// Problem  : 1801. Number of Orders in the Backlog
// Difficulty: Medium
// Tags     : Array, Heap (Priority Queue), Simulation
// Link     : https://leetcode.com/problems/number-of-orders-in-the-backlog/
// Runtime  : 41 ms (beats 53%)
// Memory   : 91608000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            
            if (type == 0) {
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {
                    int[] sellOrder = sellOrders.poll();
                    int sellPrice = sellOrder[0];
                    int sellAmount = sellOrder[1];
                    
                    if (sellAmount <= amount) {
                        amount -= sellAmount;
                    } else {
                        sellOrders.offer(new int[] { sellPrice, sellAmount - amount });
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    buyOrders.offer(new int[] { price, amount });
                }
            } else {
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                    int[] buyOrder = buyOrders.poll();
                    int buyPrice = buyOrder[0];
                    int buyAmount = buyOrder[1];
                    
                    if (buyAmount <= amount) {
                        amount -= buyAmount;
                    } else {
                        buyOrders.offer(new int[] { buyPrice, buyAmount - amount });
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    sellOrders.offer(new int[] { price, amount });
                }
            }
        }
        
        long totalOrders = 0;
        long mod = 1_000_000_007;
        
        for (int[] bo : buyOrders) {
            totalOrders = (totalOrders + bo[1]) % mod;
        }
        for (int[] so : sellOrders) {
            totalOrders = (totalOrders + so[1]) % mod;
        }
        
        return (int) totalOrders;
    }
}
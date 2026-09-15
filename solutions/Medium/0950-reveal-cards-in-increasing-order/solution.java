// ──────────────────────────────────────────────────
// Problem  : 950. Reveal Cards In Increasing Order
// Difficulty: Medium
// Tags     : Array, Queue, Sorting, Simulation
// Link     : https://leetcode.com/problems/reveal-cards-in-increasing-order/
// Runtime  : 7 ms (beats 92%)
// Memory   : 45776000 (beats 58%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        java.util.Arrays.sort(deck);
        int n = deck.length;
        int[] result = new int[n];
        java.util.Deque<Integer> queue = new java.util.LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        
        for (int card : deck) {
            result[queue.poll()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        
        return result;
    }
}
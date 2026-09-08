// ──────────────────────────────────────────────────
// Problem  : 682. Baseball Game
// Difficulty: Easy
// Tags     : Array, Stack, Simulation
// Link     : https://leetcode.com/problems/baseball-game/
// Runtime  : 3 ms (beats 80%)
// Memory   : 43564000 (beats 49%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int calPoints(String[] operations) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        
        return sum;
    }
}
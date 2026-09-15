// ──────────────────────────────────────────────────
// Problem  : 946. Validate Stack Sequences
// Difficulty: Medium
// Tags     : Array, Stack, Simulation
// Link     : https://leetcode.com/problems/validate-stack-sequences/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42760000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int j = 0;
        
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        return stack.isEmpty();
    }
}
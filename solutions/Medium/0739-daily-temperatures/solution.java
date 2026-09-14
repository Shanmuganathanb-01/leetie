// ──────────────────────────────────────────────────
// Problem  : 739. Daily Temperatures
// Difficulty: Medium
// Tags     : Array, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/daily-temperatures/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42708000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int prevIndex = stack[top--];
                ans[prevIndex] = i - prevIndex;
            }
            stack[++top] = i;
        }
        
        return ans;
    }
}
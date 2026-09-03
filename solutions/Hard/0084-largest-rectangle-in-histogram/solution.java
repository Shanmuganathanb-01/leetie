// ──────────────────────────────────────────────────
// Problem  : 84. Largest Rectangle in Histogram
// Difficulty: Hard
// Tags     : Array, Stack, Monotonic Stack, Range Minimum/Maximum Query
// Link     : https://leetcode.com/problems/largest-rectangle-in-histogram/
// Runtime  : 70 ms (beats 45%)
// Memory   : 78620000 (beats 23%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
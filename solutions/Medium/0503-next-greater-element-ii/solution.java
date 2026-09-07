// ──────────────────────────────────────────────────
// Problem  : 503. Next Greater Element II
// Difficulty: Medium
// Tags     : Array, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/next-greater-element-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 43148000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        java.util.Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}
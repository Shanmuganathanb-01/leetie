// ──────────────────────────────────────────────────
// Problem  : 1389. Create Target Array in the Given Order
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/create-target-array-in-the-given-order/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42804000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
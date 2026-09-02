// ──────────────────────────────────────────────────
// Problem  : 3653. XOR After Range Multiplication Queries I
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Simulation, Prefix Sum
// Link     : https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42660000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1_000_000_007L;
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            long v = q[3];
            
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) ((nums[idx] * v) % mod);
            }
        }
        
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        
        return ans;
    }
}
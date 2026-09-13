// ──────────────────────────────────────────────────
// Problem  : 698. Partition to K Equal Sum Subsets
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Memoization, Bitmask
// Link     : https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
// Runtime  : 1549 ms (beats 18%)
// Memory   : 42876000 (beats 89%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, 0, k, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int start, int k, int currentSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currentSum == target) {
            return backtrack(nums, visited, 0, k - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(nums, visited, i + 1, k, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
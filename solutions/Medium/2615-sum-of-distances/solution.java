// ──────────────────────────────────────────────────
// Problem  : 2615. Sum of Distances
// Difficulty: Medium
// Tags     : Array, Hash Table, Prefix Sum
// Link     : https://leetcode.com/problems/sum-of-distances/
// Runtime  : 26 ms (beats 55%)
// Memory   : 138980000 (beats 26%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            int size = indices.size();
            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long leftSum = 0;
            for (int i = 0; i < size; i++) {
                long idx = indices.get(i);
                long rightSum = totalSum - leftSum - idx;
                
                long leftDist = idx * i - leftSum;
                long rightDist = rightSum - idx * (size - 1 - i);
                
                ans[(int) idx] = leftDist + rightDist;
                leftSum += idx;
            }
        }

        return ans;
    }
}
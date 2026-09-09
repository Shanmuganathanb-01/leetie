// ──────────────────────────────────────────────────
// Problem  : 3488. Closest Equal Element Queries
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search
// Link     : https://leetcode.com/problems/closest-equal-element-queries/
// Runtime  : 113 ms (beats 49%)
// Memory   : 187008000 (beats 61%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int val = nums[q];
            List<Integer> indices = map.get(val);
            if (indices.size() == 1) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(indices, q);
            int minDist = n;

            int left = (idx > 0) ? indices.get(idx - 1) : indices.get(indices.size() - 1);
            int dist1 = Math.abs(q - left);
            minDist = Math.min(minDist, Math.min(dist1, n - dist1));

            int right = (idx < indices.size() - 1) ? indices.get(idx + 1) : indices.get(0);
            int dist2 = Math.abs(q - right);
            minDist = Math.min(minDist, Math.min(dist2, n - dist2));

            result.add(minDist);
        }

        return result;
    }
}
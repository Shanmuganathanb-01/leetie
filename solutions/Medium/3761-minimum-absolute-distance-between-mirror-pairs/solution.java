// ──────────────────────────────────────────────────
// Problem  : 3761. Minimum Absolute Distance Between Mirror Pairs
// Difficulty: Medium
// Tags     : Array, Hash Table, Math
// Link     : https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42488000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            int val = nums[j];
            if (map.containsKey(val)) {
                minDistance = Math.min(minDistance, j - map.get(val));
            }
            int rev = reverse(nums[j]);
            map.put(rev, j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}
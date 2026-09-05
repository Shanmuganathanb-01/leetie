// ──────────────────────────────────────────────────
// Problem  : 228. Summary Ranges
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/summary-ranges/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42844000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                StringBuilder sb = new StringBuilder();
                if (start == nums[i]) {
                    sb.append(start);
                } else {
                    sb.append(start).append("->").append(nums[i]);
                }
                result.add(sb.toString());
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        
        return result;
    }
}
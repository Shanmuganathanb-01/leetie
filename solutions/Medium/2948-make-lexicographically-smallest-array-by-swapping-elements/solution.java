// ──────────────────────────────────────────────────
// Problem  : 2948. Make Lexicographically Smallest Array by Swapping Elements
// Difficulty: Medium
// Tags     : Array, Union-Find, Sorting
// Link     : https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
// Runtime  : 69 ms (beats 95%)
// Memory   : 147820000 (beats 75%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        java.util.Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && sortedNums[j + 1][0] - sortedNums[j][0] <= limit) {
                j++;
            }
            
            int[] indices = new int[j - i + 1];
            for (int k = i; k <= j; k++) {
                indices[k - i] = sortedNums[k][1];
            }
            java.util.Arrays.sort(indices);
            
            for (int k = i; k <= j; k++) {
                result[indices[k - i]] = sortedNums[k][0];
            }
            
            i = j + 1;
        }
        return result;
    }
}
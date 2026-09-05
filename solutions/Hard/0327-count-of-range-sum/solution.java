// ──────────────────────────────────────────────────
// Problem  : 327. Count of Range Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/count-of-range-sum/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42588000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return mergeSort(prefixSum, 0, n + 1, lower, upper);
    }
    
    private int mergeSort(long[] sums, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(sums, left, mid, lower, upper) + mergeSort(sums, mid, right, lower, upper);
        
        int j = mid, k = mid, t = mid;
        long[] cache = new long[right - left];
        int r = 0;
        
        for (int i = left, p = 0; i < mid; i++, p++) {
            while (k < right && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < right && sums[j] - sums[i] <= upper) {
                j++;
            }
            count += j - k;
            
            while (t < right && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r++] = sums[i];
        }
        
        System.arraycopy(cache, 0, sums, left, t - left);
        return count;
    }
}
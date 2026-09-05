// ──────────────────────────────────────────────────
// Problem  : 321. Create Maximum Number
// Difficulty: Hard
// Tags     : Array, Two Pointers, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/create-maximum-number/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42960000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] bestResult = new int[k];
        
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        
        for (int i = start; i <= end; i++) {
            int[] sub1 = getMaxSubsequence(nums1, i);
            int[] sub2 = getMaxSubsequence(nums2, k - i);
            int[] candidate = merge(sub1, sub2, k);
            
            if (isGreater(candidate, 0, bestResult, 0)) {
                bestResult = candidate;
            }
        }
        
        return bestResult;
    }
    
    private int[] getMaxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        int n = nums.length;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && result[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0, j = 0, r = 0;
        
        while (r < k) {
            if (isGreater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }
        
        return result;
    }
    
    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] != nums2[j]) {
                return nums1[i] > nums2[j];
            }
            i++;
            j++;
        }
        return i != nums1.length;
    }
}
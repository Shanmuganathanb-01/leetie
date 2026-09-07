// ──────────────────────────────────────────────────
// Problem  : 493. Reverse Pairs
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/reverse-pairs/
// Runtime  : 40 ms (beats 98%)
// Memory   : 64544000 (beats 31%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, k = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = nums[l++];
        }
        while (r <= right) {
            temp[k++] = nums[r++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        
        return count;
    }
}
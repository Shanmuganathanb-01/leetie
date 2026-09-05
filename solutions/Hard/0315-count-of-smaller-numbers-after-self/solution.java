// ──────────────────────────────────────────────────
// Problem  : 315. Count of Smaller Numbers After Self
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// Runtime  : 59 ms (beats 63%)
// Memory   : 98400000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    class Item {
        int val;
        int index;
        Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }
        
        int[] counts = new int[n];
        mergeSort(items, 0, n - 1, counts);
        
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    private void mergeSort(Item[] items, int left, int right, int[] counts) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(items, left, mid, counts);
        mergeSort(items, mid + 1, right, counts);
        merge(items, left, mid, right, counts);
    }

    private void merge(Item[] items, int left, int mid, int right, int[] counts) {
        Item[] temp = new Item[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightSmallerCount = 0;

        while (i <= mid && j <= right) {
            if (items[i].val <= items[j].val) {
                counts[items[i].index] += rightSmallerCount;
                temp[k++] = items[i++];
            } else {
                rightSmallerCount++;
                temp[k++] = items[j++];
            }
        }

        while (i <= mid) {
            counts[items[i].index] += rightSmallerCount;
            temp[k++] = items[i++];
        }

        while (j <= right) {
            temp[k++] = items[j++];
        }

        System.arraycopy(temp, 0, items, left, temp.length);
    }
}
// ──────────────────────────────────────────────────
// Problem  : 307. Range Sum Query - Mutable
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Design, Binary Indexed Tree, Segment Tree, Sqrt Decomposition
// Link     : https://leetcode.com/problems/range-sum-query-mutable/
// Runtime  : 99 ms (beats 22%)
// Memory   : 134528000 (beats 29%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n * 4];
        buildTree(0, 0, n - 1);
    }
    
    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(2 * node + 1, start, mid);
        buildTree(2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        updateTree(0, 0, n - 1, index, val);
    }
    
    private void updateTree(int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateTree(2 * node + 1, start, mid, index, val);
        } else {
            updateTree(2 * node + 2, mid + 1, end, index, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public int sumRange(int left, int right) {
        return queryTree(0, 0, n - 1, left, right);
    }
    
    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = queryTree(2 * node + 1, start, mid, l, r);
        int p2 = queryTree(2 * node + 2, mid + 1, end, l, r);
        return p1 + p2;
    }
}
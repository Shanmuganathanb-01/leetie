// ──────────────────────────────────────────────────
// Problem  : 654. Maximum Binary Tree
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Stack, Tree, Monotonic Stack, Binary Tree, Cartesian Tree
// Link     : https://leetcode.com/problems/maximum-binary-tree/
// Runtime  : 1 ms (beats 100%)
// Memory   : 47228000 (beats 15%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = build(nums, start, maxIdx - 1);
        node.right = build(nums, maxIdx + 1, end);
        
        return node;
    }
}
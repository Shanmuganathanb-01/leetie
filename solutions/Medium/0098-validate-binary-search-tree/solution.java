// ──────────────────────────────────────────────────
// Problem  : 98. Validate Binary Search Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/validate-binary-search-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45580000 (beats 11%)
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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
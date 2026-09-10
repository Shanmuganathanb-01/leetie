// ──────────────────────────────────────────────────
// Problem  : 2265. Count Nodes Equal to Average of Subtree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45452000 (beats 63%)
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
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int sum = node.val + left[0] + right[0];
        int n = 1 + left[1] + right[1];

        if (sum / n == node.val) {
            count++;
        }

        return new int[] {sum, n};
    }
}
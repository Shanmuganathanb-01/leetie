// ──────────────────────────────────────────────────
// Problem  : 94. Binary Tree Inorder Traversal
// Difficulty: Easy
// Tags     : Stack, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-inorder-traversal/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43008000 (beats 71%)
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
    List<Integer> l = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return l;
    }
}
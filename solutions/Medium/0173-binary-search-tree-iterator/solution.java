// ──────────────────────────────────────────────────
// Problem  : 173. Binary Search Tree Iterator
// Difficulty: Medium
// Tags     : Stack, Tree, Design, Binary Search Tree, Binary Tree, Iterator
// Link     : https://leetcode.com/problems/binary-search-tree-iterator/
// Runtime  : 18 ms (beats 47%)
// Memory   : 50096000 (beats 81%)
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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        pushLeft(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
// ──────────────────────────────────────────────────
// Problem  : 105. Construct Binary Tree from Preorder and Inorder Traversal
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Tree, Binary Tree
// Link     : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Runtime  : 1 ms (beats 97%)
// Memory   : 46320000 (beats 52%)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        java.util.Map<Integer, Integer> inorderMap = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, java.util.Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inorderMap.get(root.val);
        int leftSize = inIndex - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inIndex - 1, inorderMap);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, inIndex + 1, inEnd, inorderMap);
        
        return root;
    }
}
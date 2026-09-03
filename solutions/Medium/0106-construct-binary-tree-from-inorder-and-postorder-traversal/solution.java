// ──────────────────────────────────────────────────
// Problem  : 106. Construct Binary Tree from Inorder and Postorder Traversal
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Tree, Binary Tree
// Link     : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Runtime  : 2 ms (beats 63%)
// Memory   : 46380000 (beats 50%)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        java.util.Map<Integer, Integer> inorderMap = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }
    
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, java.util.Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inorderMap.get(root.val);
        int leftSize = inIndex - inStart;
        
        root.left = build(inorder, inStart, inIndex - 1, postorder, postStart, postStart + leftSize - 1, inorderMap);
        root.right = build(inorder, inIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, inorderMap);
        
        return root;
    }
}
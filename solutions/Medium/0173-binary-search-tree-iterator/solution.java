// ──────────────────────────────────────────────────
// Problem  : 173. Binary Search Tree Iterator
// Difficulty: Medium
// Tags     : Stack, Tree, Design, Binary Search Tree, Binary Tree, Iterator
// Link     : https://leetcode.com/problems/binary-search-tree-iterator/
// Runtime  : 15 ms (beats 100%)
// Memory   : 50008000 (beats 81%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
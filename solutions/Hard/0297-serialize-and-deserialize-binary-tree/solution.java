// ──────────────────────────────────────────────────
// Problem  : 297. Serialize and Deserialize Binary Tree
// Difficulty: Hard
// Tags     : String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Tree
// Link     : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Runtime  : 9 ms (beats 83%)
// Memory   : 48940000 (beats 8%)
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
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        java.util.Queue<String> nodes = new java.util.LinkedList<>(java.util.Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(java.util.Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
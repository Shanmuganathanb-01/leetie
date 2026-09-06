// ──────────────────────────────────────────────────
// Problem  : 427. Construct Quad Tree
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Tree, Matrix
// Link     : https://leetcode.com/problems/construct-quad-tree/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46756000 (beats 35%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    
    private Node build(int[][] grid, int r, int c, int length) {
        if (isUniform(grid, r, c, length)) {
            return new Node(grid[r][c] == 1, true);
        }
        
        Node node = new Node(true, false);
        int half = length / 2;
        
        node.topLeft = build(grid, r, c, half);
        node.topRight = build(grid, r, c + half, half);
        node.bottomLeft = build(grid, r + half, c, half);
        node.bottomRight = build(grid, r + half, c + half, half);
        
        return node;
    }
    
    private boolean isUniform(int[][] grid, int r, int c, int length) {
        int val = grid[r][c];
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
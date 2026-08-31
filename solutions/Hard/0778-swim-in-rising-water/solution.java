// ──────────────────────────────────────────────────
// Problem  : 778. Swim in Rising Water
// Difficulty: Hard
// Tags     : Array, Binary Search, Depth-First Search, Breadth-First Search, Union-Find, Minimax, Heap (Priority Queue), Matrix, Dijkstra's Algorithm
// Link     : https://leetcode.com/problems/swim-in-rising-water/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42540000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        
        int[][] positions = new int[n * n][2];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                positions[grid[r][c]] = new int[]{r, c};
            }
        }
        
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int t = 0; t < n * n; t++) {
            int r = positions[t][0];
            int c = positions[t][1];
            visited[r][c] = true;
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && visited[nr][nc]) {
                    uf.union(r * n + c, nr * n + nc);
                }
            }
            
            if (uf.connected(0, n * n - 1)) {
                return t;
            }
        }
        
        return 0;
    }
    
    private class UnionFind {
        private int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
        
        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }
}
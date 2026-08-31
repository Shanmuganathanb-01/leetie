// ──────────────────────────────────────────────────
// Problem  : 785. Is Graph Bipartite?
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Graph Coloring, Bipartite Graph
// Link     : https://leetcode.com/problems/is-graph-bipartite/
// Runtime  : 2 ms (beats 38%)
// Memory   : 47160000 (beats 57%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int neighbor = graph[i][j];
                if (uf.connected(i, neighbor)) {
                    return false;
                }
                uf.union(graph[i][0], neighbor);
            }
        }

        return true;
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
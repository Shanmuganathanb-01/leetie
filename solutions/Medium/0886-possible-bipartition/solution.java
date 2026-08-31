// ──────────────────────────────────────────────────
// Problem  : 886. Possible Bipartition
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Graph Coloring, Bipartite Graph
// Link     : https://leetcode.com/problems/possible-bipartition/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41956000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        UnionFind uf = new UnionFind(n + 1);

        for (int i = 1; i <= n; i++) {
            for (int neighbor : graph[i]) {
                if (uf.connected(i, neighbor)) {
                    return false;
                }
                uf.union(graph[i].get(0), neighbor);
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
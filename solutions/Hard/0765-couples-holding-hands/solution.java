// ──────────────────────────────────────────────────
// Problem  : 765. Couples Holding Hands
// Difficulty: Hard
// Tags     : Greedy, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/couples-holding-hands/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43000000 (beats 39%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < row.length; i += 2) {
            int couple1 = row[i] / 2;
            int couple2 = row[i + 1] / 2;
            uf.union(couple1, couple2);
        }

        return n - uf.getCount();
    }

    private class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.count = n;
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
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
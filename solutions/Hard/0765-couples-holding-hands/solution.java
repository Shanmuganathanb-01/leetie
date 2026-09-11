// ──────────────────────────────────────────────────
// Problem  : 765. Couples Holding Hands
// Difficulty: Hard
// Tags     : Greedy, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
// Link     : https://leetcode.com/problems/couples-holding-hands/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42448000 (beats 0%)
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

        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
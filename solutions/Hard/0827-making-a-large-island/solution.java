// ──────────────────────────────────────────────────
// Problem  : 827. Making A Large Island
// Difficulty: Hard
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
// Link     : https://leetcode.com/problems/making-a-large-island/
// Runtime  : 64 ms (beats 95%)
// Memory   : 147936000 (beats 51%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    if (r + 1 < n && grid[r + 1][c] == 1) {
                        uf.union(r * n + c, (r + 1) * n + c);
                    }
                    if (c + 1 < n && grid[r][c + 1] == 1) {
                        uf.union(r * n + c, r * n + (c + 1));
                    }
                }
            }
        }

        int maxIsland = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean hasZero = false;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    hasZero = true;
                    Set<Integer> neighborRoots = new HashSet<>();
                    int currentSize = 1;

                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int root = uf.find(nr * n + nc);
                            if (neighborRoots.add(root)) {
                                currentSize += uf.getSize(root);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, currentSize);
                }
            }
        }

        return hasZero ? maxIsland : n * n;
    }

    private class UnionFind {
        private int[] parent;
        private int[] sz;

        public UnionFind(int n) {
            parent = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                sz[i] = 1;
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
                sz[rootJ] += sz[rootI];
            }
        }

        public int getSize(int i) {
            return sz[find(i)];
        }
    }
}
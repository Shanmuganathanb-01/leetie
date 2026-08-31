// ──────────────────────────────────────────────────
// Problem  : 803. Bricks Falling When Hit
// Difficulty: Hard
// Tags     : Array, Union-Find, Matrix
// Link     : https://leetcode.com/problems/bricks-falling-when-hit/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42952000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int rows;
    private int cols;
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;

        int[][] copy = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                copy[r][c] = grid[r][c];
            }
        }

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        int size = rows * cols;
        UnionFind uf = new UnionFind(size + 1);

        for (int c = 0; c < cols; c++) {
            if (copy[0][c] == 1) {
                uf.union(c, size);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (copy[r][c] == 1) {
                    if (r + 1 < rows && copy[r + 1][c] == 1) {
                        uf.union(r * cols + c, (r + 1) * cols + c);
                    }
                    if (c + 1 < cols && copy[r][c + 1] == 1) {
                        uf.union(r * cols + c, r * cols + (c + 1));
                    }
                }
            }
        }

        int[] res = new int[hits.length];

        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0];
            int c = hits[i][1];

            if (grid[r][c] == 0) {
                continue;
            }

            int prevRoofSize = uf.getSize(size);

            if (r == 0) {
                uf.union(c, size);
            }

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && copy[nr][nc] == 1) {
                    uf.union(r * cols + c, nr * cols + nc);
                }
            }

            copy[r][c] = 1;
            int currentRoofSize = uf.getSize(size);

            if (currentRoofSize > prevRoofSize) {
                res[i] = currentRoofSize - prevRoofSize - 1;
            }
        }

        return res;
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
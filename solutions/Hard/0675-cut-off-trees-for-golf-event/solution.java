// ──────────────────────────────────────────────────
// Problem  : 675. Cut Off Trees for Golf Event
// Difficulty: Hard
// Tags     : Array, Breadth-First Search, Heap (Priority Queue), Matrix
// Link     : https://leetcode.com/problems/cut-off-trees-for-golf-event/
// Runtime  : 386 ms (beats 72%)
// Memory   : 47060000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    trees.add(new int[]{h, i, j});
                }
            }
        }
        
        trees.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int ans = 0;
        int sr = 0, sc = 0;
        
        for (int[] tree : trees) {
            int steps = bfs(forest, sr, sc, tree[1], tree[2], m, n);
            if (steps == -1) return -1;
            ans += steps;
            sr = tree[1];
            sc = tree[2];
        }
        
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc, int m, int n) {
        if (sr == tr && sc == tc) return 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        int step = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && forest.get(nr).get(nc) > 0) {
                        if (nr == tr && nc == tc) return step;
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}
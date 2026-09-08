// ──────────────────────────────────────────────────
// Problem  : 675. Cut Off Trees for Golf Event
// Difficulty: Hard
// Tags     : Array, Breadth-First Search, Heap (Priority Queue), Matrix
// Link     : https://leetcode.com/problems/cut-off-trees-for-golf-event/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42332000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    trees.add(new int[] { h, i, j });
                }
            }
        }
        
        trees.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int startRow = 0;
        int startCol = 0;
        int totalSteps = 0;
        
        for (int[] tree : trees) {
            int targetHeight = tree[0];
            int targetRow = tree[1];
            int targetCol = tree[2];
            
            int steps = bfs(forest, startRow, startCol, targetRow, targetCol, m, n);
            if (steps == -1) {
                return -1;
            }
            
            totalSteps += steps;
            startRow = targetRow;
            startCol = targetCol;
        }
        
        return totalSteps;
    }
    
    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc, int m, int n) {
        if (sr == tr && sc == tc) {
            return 0;
        }
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] { sr, sc });
        visited[sr][sc] = true;
        
        int steps = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (nr == tr && nc == tc) {
                        return steps;
                    }
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && forest.get(nr).get(nc) != 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        
        return -1;
    }
}
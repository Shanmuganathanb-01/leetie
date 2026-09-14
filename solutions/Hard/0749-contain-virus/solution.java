// ──────────────────────────────────────────────────
// Problem  : 749. Contain Virus
// Difficulty: Hard
// Tags     : Array, Depth-First Search, Breadth-First Search, Matrix, Simulation
// Link     : https://leetcode.com/problems/contain-virus/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42540000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        int ans = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> perimeters = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];

            for (int r = 0; r < m; ++r) {
                for (int c = 0; c < n; ++c) {
                    if (isInfected[r][c] == 1 && !visited[r][c]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> frontier = new HashSet<>();
                        int[] perimeter = new int[1];

                        dfs(isInfected, visited, r, c, region, frontier, perimeter, dr, dc);

                        if (!frontier.isEmpty()) {
                            regions.add(region);
                            frontiers.add(frontier);
                            perimeters.add(perimeter[0]);
                        }
                    }
                }
            }

            if (regions.isEmpty()) break;

            int maxIdx = 0;
            for (int i = 1; i < frontiers.size(); ++i) {
                if (frontiers.get(i).size() > frontiers.get(maxIdx).size()) {
                    maxIdx = i;
                }
            }

            ans += perimeters.get(maxIdx);

            for (int i = 0; i < regions.size(); ++i) {
                if (i == maxIdx) {
                    for (int code : regions.get(i)) {
                        isInfected[code / n][code % n] = 2;
                    }
                } else {
                    for (int code : frontiers.get(i)) {
                        isInfected[code / n][code % n] = 1;
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] isInfected, boolean[][] visited, int r, int c, 
                     Set<Integer> region, Set<Integer> frontier, int[] perimeter, 
                     int[] dr, int[] dc) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        visited[r][c] = true;
        region.add(r * n + c);

        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (isInfected[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(isInfected, visited, nr, nc, region, frontier, perimeter, dr, dc);
                } else if (isInfected[nr][nc] == 0) {
                    frontier.add(nr * n + nc);
                    perimeter[0]++;
                }
            }
        }
    }
}
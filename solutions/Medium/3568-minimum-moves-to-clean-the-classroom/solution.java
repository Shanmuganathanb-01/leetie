// ──────────────────────────────────────────────────
// Problem  : 3568. Minimum Moves to Clean the Classroom
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Breadth-First Search, Matrix
// Link     : https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
// Runtime  : 129 ms (beats 90%)
// Memory   : 61076000 (beats 76%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startX = -1, startY = -1;
        int litterCount = 0;
        
        int[][] litterMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterMap[i][j] = 1 << litterCount;
                    litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        if (targetMask == 0) return 0;
        
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < (1 << litterCount); k++) {
                    maxEnergy[i][j][k] = -1;
                }
            }
        }
        
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{startX, startY, 0, energy, 0});
        maxEnergy[startX][startY][0] = energy;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], mask = curr[2], e = curr[3], moves = curr[4];
            
            if (mask == targetMask) {
                return moves;
            }
            
            if (e == 0) continue;
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int nextMask = mask;
                    char cell = classroom[nr].charAt(nc);
                    
                    if (cell == 'L') {
                        nextMask |= litterMap[nr][nc];
                    }
                    
                    int nextEnergy = e - 1;
                    if (cell == 'R') {
                        nextEnergy = energy;
                    }
                    
                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy, moves + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
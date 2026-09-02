// ──────────────────────────────────────────────────
// Problem  : 874. Walking Robot Simulation
// Difficulty: Medium
// Tags     : Array, Hash Table, Simulation
// Link     : https://leetcode.com/problems/walking-robot-simulation/
// Runtime  : 103 ms (beats 22%)
// Memory   : 69168000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int x = 0, y = 0, dir = 0;
        int maxDistSq = 0;
        
        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (obstacleSet.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                }
            }
        }
        
        return maxDistSq;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 735. Asteroid Collision
// Difficulty: Medium
// Tags     : Array, Stack, Simulation
// Link     : https://leetcode.com/problems/asteroid-collision/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42876000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;
        
        for (int ast : asteroids) {
            boolean alive = true;
            while (alive && ast < 0 && top >= 0 && stack[top] > 0) {
                alive = stack[top] < -ast;
                if (stack[top] <= -ast) {
                    top--;
                }
            }
            if (alive) {
                stack[++top] = ast;
            }
        }
        
        int[] res = new int[top + 1];
        System.arraycopy(stack, 0, res, 0, top + 1);
        return res;
    }
}
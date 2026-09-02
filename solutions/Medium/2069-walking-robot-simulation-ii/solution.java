// ──────────────────────────────────────────────────
// Problem  : 2069. Walking Robot Simulation II
// Difficulty: Medium
// Tags     : Design, Simulation
// Link     : https://leetcode.com/problems/walking-robot-simulation-ii/
// Runtime  : 62 ms (beats 47%)
// Memory   : 57712000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Robot {
    private int width;
    private int height;
    private int perimeter;
    private int pos = 0;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
    }
    
    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }
    
    public int[] getPos() {
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{width - 1 - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, height - 1 - (pos - (2 * width + height - 3))};
        }
    }
    
    public String getDir() {
        if (!moved) {
            return "East";
        }
        if (pos > 0 && pos < width) {
            return "East";
        } else if (pos >= width && pos < width + height - 1) {
            return "North";
        } else if (pos >= width + height - 1 && pos < 2 * width + height - 2) {
            return "West";
        } else {
            return "South";
        }
    }
}
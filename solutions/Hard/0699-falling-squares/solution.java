// ──────────────────────────────────────────────────
// Problem  : 699. Falling Squares
// Difficulty: Hard
// Tags     : Array, Segment Tree, Ordered Set
// Link     : https://leetcode.com/problems/falling-squares/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42876000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private class Interval {
        int start, end, height;
        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }
    
    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;
        
        for (int[] pos : positions) {
            int left = pos[0];
            int side = pos[1];
            int right = left + side;
            
            int baseHeight = 0;
            for (Interval interval : intervals) {
                if (interval.end > left && interval.start < right) {
                    baseHeight = Math.max(baseHeight, interval.height);
                }
            }
            
            int currentHeight = baseHeight + side;
            intervals.add(new Interval(left, right, currentHeight));
            maxHeight = Math.max(maxHeight, currentHeight);
            result.add(maxHeight);
        }
        
        return result;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 630. Course Schedule III
// Difficulty: Hard
// Tags     : Array, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/course-schedule-iii/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42720000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int scheduleCourse(int[][] courses) {
        java.util.Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int time = 0;
        
        for (int[] c : courses) {
            int duration = c[0];
            int lastDay = c[1];
            time += duration;
            pq.offer(duration);
            
            if (time > lastDay) {
                time -= pq.poll();
            }
        }
        
        return pq.size();
    }
}
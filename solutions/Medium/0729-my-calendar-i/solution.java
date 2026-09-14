// ──────────────────────────────────────────────────
// Problem  : 729. My Calendar I
// Difficulty: Medium
// Tags     : Array, Binary Search, Design, Segment Tree, Ordered Set
// Link     : https://leetcode.com/problems/my-calendar-i/
// Runtime  : 22 ms (beats 82%)
// Memory   : 46996000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime);
        Integer next = calendar.ceilingKey(startTime);
        
        if ((prev == null || calendar.get(prev) <= startTime) &&
            (next == null || endTime <= next)) {
            calendar.put(startTime, endTime);
            return true;
        }
        return false;
    }
}
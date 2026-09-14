// ──────────────────────────────────────────────────
// Problem  : 731. My Calendar II
// Difficulty: Medium
// Tags     : Array, Binary Search, Design, Segment Tree, Prefix Sum, Ordered Set
// Link     : https://leetcode.com/problems/my-calendar-ii/
// Runtime  : 55 ms (beats 59%)
// Memory   : 47228000 (beats 67%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] overlap : overlaps) {
            if (startTime < overlap[1] && endTime > overlap[0]) {
                return false;
            }
        }
        
        for (int[] booking : bookings) {
            if (startTime < booking[1] && endTime > booking[0]) {
                overlaps.add(new int[]{Math.max(startTime, booking[0]), Math.min(endTime, booking[1])});
            }
        }
        
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 218. The Skyline Problem
// Difficulty: Hard
// Tags     : Array, Divide and Conquer, Binary Indexed Tree, Segment Tree, Sweep Line, Sorting, Heap (Priority Queue), Ordered Set
// Link     : https://leetcode.com/problems/the-skyline-problem/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42516000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }
        
        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);
        
        List<List<Integer>> result = new ArrayList<>();
        int prevMaxHeight = 0;
        
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            
            if (h < 0) {
                heights.put(-h, heights.getOrDefault(-h, 0) + 1);
            } else {
                int count = heights.get(h);
                if (count == 1) {
                    heights.remove(h);
                } else {
                    heights.put(h, count - 1);
                }
            }
            
            int currMaxHeight = heights.lastKey();
            if (currMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        
        return result;
    }
}
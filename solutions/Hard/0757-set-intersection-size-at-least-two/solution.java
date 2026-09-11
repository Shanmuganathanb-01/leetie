// ──────────────────────────────────────────────────
// Problem  : 757. Set Intersection Size At Least Two
// Difficulty: Hard
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/set-intersection-size-at-least-two/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42788000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        int p1 = -1, p2 = -1;
        int ans = 0;
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            boolean hasP1 = (p1 >= start && p1 <= end);
            boolean hasP2 = (p2 >= start && p2 <= end);
            
            if (hasP1 && hasP2) {
                continue;
            } else if (hasP2) {
                p1 = p2;
                p2 = end;
                ans++;
            } else {
                p1 = end - 1;
                p2 = end;
                ans += 2;
            }
        }
        
        return ans;
    }
}
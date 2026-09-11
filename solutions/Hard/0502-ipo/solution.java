// ──────────────────────────────────────────────────
// Problem  : 502. IPO
// Difficulty: Hard
// Tags     : Array, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/ipo/
// Runtime  : 101 ms (beats 71%)
// Memory   : 132984000 (beats 74%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int i = 0;
        for (int j = 0; j < k; j++) {
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }
            
            if (maxHeap.isEmpty()) {
                break;
            }
            
            w += maxHeap.poll();
        }
        
        return w;
    }
}
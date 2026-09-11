// ──────────────────────────────────────────────────
// Problem  : 649. Dota2 Senate
// Difficulty: Medium
// Tags     : String, Greedy, Queue
// Link     : https://leetcode.com/problems/dota2-senate/
// Runtime  : 12 ms (beats 44%)
// Memory   : 47072000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }
        
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            
            if (rIndex < dIndex) {
                rQueue.add(rIndex + n);
            } else {
                dQueue.add(dIndex + n);
            }
        }
        
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
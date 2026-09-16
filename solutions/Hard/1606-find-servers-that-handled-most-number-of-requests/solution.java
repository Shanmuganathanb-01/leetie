// ──────────────────────────────────────────────────
// Problem  : 1606. Find Servers That Handled Most Number of Requests
// Difficulty: Hard
// Tags     : Array, Heap (Priority Queue), Simulation, Ordered Set
// Link     : https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
// Runtime  : 1 ms (beats 0%)
// Memory   : 43020000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] requestsHandled = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }
            
            if (available.isEmpty()) {
                continue;
            }
            
            Integer server = available.ceiling(i % k);
            if (server == null) {
                server = available.first();
            }
            
            available.remove(server);
            busy.offer(new int[] { time + load[i], server });
            
            requestsHandled[server]++;
            maxRequests = Math.max(maxRequests, requestsHandled[server]);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestsHandled[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}
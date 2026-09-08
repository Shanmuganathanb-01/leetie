// ──────────────────────────────────────────────────
// Problem  : 692. Top K Frequent Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
// Link     : https://leetcode.com/problems/top-k-frequent-words/
// Runtime  : 7 ms (beats 88%)
// Memory   : 46448000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            if (freq1 != freq2) {
                return freq1 - freq2;
            }
            return w2.compareTo(w1);
        });
        
        for (String word : count.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        java.util.Collections.reverse(result);
        return result;
    }
}
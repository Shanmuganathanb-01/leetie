// ──────────────────────────────────────────────────
// Problem  : 1722. Minimize Hamming Distance After Swap Operations
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Union-Find
// Link     : https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
// Runtime  : 52 ms (beats 60%)
// Memory   : 135540000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DisjointSet dsu = new DisjointSet(n);
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int hammingDistance = 0;
        for (List<Integer> indices : components.values()) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int idx : indices) {
                countMap.put(source[idx], countMap.getOrDefault(source[idx], 0) + 1);
            }
            for (int idx : indices) {
                int val = target[idx];
                if (countMap.getOrDefault(val, 0) > 0) {
                    countMap.put(val, countMap.get(val) - 1);
                } else {
                    hammingDistance++;
                }
            }
        }

        return hammingDistance;
    }

    private static class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}
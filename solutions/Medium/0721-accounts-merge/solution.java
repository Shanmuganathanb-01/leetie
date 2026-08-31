// ──────────────────────────────────────────────────
// Problem  : 721. Accounts Merge
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Depth-First Search, Breadth-First Search, Union-Find, Sorting
// Link     : https://leetcode.com/problems/accounts-merge/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42912000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToId = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else {
                    emailToId.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = uf.find(emailToId.get(email));
            idToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            
            List<String> account = new ArrayList<>();
            account.add(accounts.get(id).get(0));
            account.addAll(emails);
            
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }

    private class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}
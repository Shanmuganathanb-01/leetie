// ──────────────────────────────────────────────────
// Problem  : 745. Prefix and Suffix Search
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Design, Trie
// Link     : https://leetcode.com/problems/prefix-and-suffix-search/
// Runtime  : 297 ms (beats 63%)
// Memory   : 278368000 (beats 21%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class TrieNode {
    TrieNode[] children;
    int weight;
    
    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}

class WordFilter {
    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight];
            int len = word.length();
            for (int i = 0; i <= len; i++) {
                String prefixAndSuffix = word.substring(len - i) + "{" + word;
                insert(prefixAndSuffix, weight);
            }
        }
    }
    
    private void insert(String word, int weight) {
        TrieNode node = root;
        node.weight = weight;
        for (char c : word.toCharArray()) {
            int index = c == '{' ? 26 : c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.weight = weight;
        }
    }
    
    public int f(String pref, String suff) {
        TrieNode node = root;
        String searchWord = suff + "{" + pref;
        for (char c : searchWord.toCharArray()) {
            int index = c == '{' ? 26 : c - 'a';
            if (node.children[index] == null) {
                return -1;
            }
            node = node.children[index];
        }
        return node.weight;
    }
}
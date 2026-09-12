// ──────────────────────────────────────────────────
// Problem  : 211. Design Add and Search Words Data Structure
// Difficulty: Medium
// Tags     : String, Depth-First Search, Design, Trie
// Link     : https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Runtime  : 201 ms (beats 59%)
// Memory   : 274284000 (beats 59%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int i, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(i);
        if (c != '.') {
            return searchInNode(word, i + 1, node.children[c - 'a']);
        }
        for (int j = 0; j < 26; j++) {
            if (node.children[j] != null && searchInNode(word, i + 1, node.children[j])) {
                return true;
            }
        }
        return false;
    }
}
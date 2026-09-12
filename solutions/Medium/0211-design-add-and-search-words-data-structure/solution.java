// ──────────────────────────────────────────────────
// Problem  : 211. Design Add and Search Words Data Structure
// Difficulty: Medium
// Tags     : String, Depth-First Search, Design, Trie
// Link     : https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Runtime  : 231 ms (beats 31%)
// Memory   : 277036000 (beats 26%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class WordDictionary {
    
    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return searchHelper(word, index + 1, node.children[c - 'a']);
        }
    }
}
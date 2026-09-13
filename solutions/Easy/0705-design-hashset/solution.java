// ──────────────────────────────────────────────────
// Problem  : 705. Design HashSet
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashset/
// Runtime  : 0 ms (beats 0%)
// Memory   : 43568000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}
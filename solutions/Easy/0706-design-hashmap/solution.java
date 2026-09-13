// ──────────────────────────────────────────────────
// Problem  : 706. Design HashMap
// Difficulty: Easy
// Tags     : Array, Hash Table, Linked List, Design, Hash Function
// Link     : https://leetcode.com/problems/design-hashmap/
// Runtime  : 34 ms (beats 31%)
// Memory   : 57716000 (beats 25%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyHashMap {
    private int[] data;

    public MyHashMap() {
        data = new int[1000001];
        java.util.Arrays.fill(data, -1);
    }
    
    public void put(int key, int value) {
        data[key] = value;
    }
    
    public int get(int key) {
        return data[key];
    }
    
    public void remove(int key) {
        data[key] = -1;
    }
}
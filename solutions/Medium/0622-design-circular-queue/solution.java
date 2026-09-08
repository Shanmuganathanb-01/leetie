// ──────────────────────────────────────────────────
// Problem  : 622. Design Circular Queue
// Difficulty: Medium
// Tags     : Array, Linked List, Design, Queue
// Link     : https://leetcode.com/problems/design-circular-queue/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42808000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        head = 0;
        tail = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
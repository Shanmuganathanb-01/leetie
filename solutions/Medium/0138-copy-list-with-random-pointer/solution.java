// ──────────────────────────────────────────────────
// Problem  : 138. Copy List with Random Pointer
// Difficulty: Medium
// Tags     : Hash Table, Linked List
// Link     : https://leetcode.com/problems/copy-list-with-random-pointer/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42752000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // First pass: Create all new nodes and store the mapping
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: Assign next and random pointers for each new node
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
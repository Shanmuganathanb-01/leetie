// ──────────────────────────────────────────────────
// Problem  : 133. Clone Graph
// Difficulty: Medium
// Tags     : Hash Table, Depth-First Search, Breadth-First Search, Graph Theory
// Link     : https://leetcode.com/problems/clone-graph/
// Runtime  : 11 ms (beats 0%)
// Memory   : 42452000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
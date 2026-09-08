// ──────────────────────────────────────────────────
// Problem  : 690. Employee Importance
// Difficulty: Medium
// Tags     : Array, Hash Table, Tree, Depth-First Search, Breadth-First Search
// Link     : https://leetcode.com/problems/employee-importance/
// Runtime  : 2 ms (beats 99%)
// Memory   : 47856000 (beats 78%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        for (int subId : employee.subordinates) {
            total += dfs(map, subId);
        }
        return total;
    }
}
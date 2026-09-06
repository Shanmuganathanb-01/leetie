// ──────────────────────────────────────────────────
// Problem  : 350. Intersection of Two Arrays II
// Difficulty: Easy
// Tags     : Array, Hash Table, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Runtime  : 3 ms (beats 95%)
// Memory   : 44848000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
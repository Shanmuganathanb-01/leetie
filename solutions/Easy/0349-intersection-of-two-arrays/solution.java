// ──────────────────────────────────────────────────
// Problem  : 349. Intersection of Two Arrays
// Difficulty: Easy
// Tags     : Array, Hash Table, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/intersection-of-two-arrays/
// Runtime  : 2 ms (beats 97%)
// Memory   : 45008000 (beats 40%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        java.util.Set<Integer> intersectionSet = new java.util.HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }
        
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (int num : intersectionSet) {
            result[i++] = num;
        }
        return result;
    }
}
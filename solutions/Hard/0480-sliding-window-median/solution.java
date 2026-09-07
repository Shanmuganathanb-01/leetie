// ──────────────────────────────────────────────────
// Problem  : 480. Sliding Window Median
// Difficulty: Hard
// Tags     : Array, Hash Table, Sliding Window, Heap (Priority Queue), Treap
// Link     : https://leetcode.com/problems/sliding-window-median/
// Runtime  : 136 ms (beats 15%)
// Memory   : 68828000 (beats 18%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        Comparator<Integer> comp = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
        TreeSet<Integer> left = new TreeSet<>(comp.reversed());
        TreeSet<Integer> right = new TreeSet<>(comp);

        for (int i = 0; i < n; i++) {
            left.add(i);
            right.add(left.pollFirst());
            if (right.size() > left.size()) {
                left.add(right.pollFirst());
            }

            if (left.size() + right.size() == k) {
                int idx = i - k + 1;
                if (k % 2 == 1) {
                    res[idx] = nums[left.first()];
                } else {
                    res[idx] = ((double) nums[left.first()] + nums[right.first()]) / 2.0;
                }

                int rem = i - k + 1;
                if (!left.remove(rem)) {
                    right.remove(rem);
                }
            }
        }

        return res;
    }
}
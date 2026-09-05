// ──────────────────────────────────────────────────
// Problem  : 216. Combination Sum III
// Difficulty: Medium
// Tags     : Array, Backtracking
// Link     : https://leetcode.com/problems/combination-sum-iii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42236000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (tempList.size() > k || remain < 0) {
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(result, tempList, k, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
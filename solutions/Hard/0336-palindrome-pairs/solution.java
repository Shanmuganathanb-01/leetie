// ──────────────────────────────────────────────────
// Problem  : 336. Palindrome Pairs
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Trie, Hash Function
// Link     : https://leetcode.com/problems/palindrome-pairs/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42416000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }
                
                if (j != word.length() && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 609. Find Duplicate File in System
// Difficulty: Medium
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/find-duplicate-file-in-system/
// Runtime  : 3 ms (beats 0%)
// Memory   : 44908000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String pathInfo : paths) {
            String[] parts = pathInfo.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];
                int openParen = file.indexOf('(');
                int closeParen = file.indexOf(')');

                String fileName = file.substring(0, openParen);
                String content = file.substring(openParen + 1, closeParen);

                String fullPath = dir + "/" + fileName;

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }
}
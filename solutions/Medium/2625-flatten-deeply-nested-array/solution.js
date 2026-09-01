// ──────────────────────────────────────────────────
// Problem  : 2625. Flatten Deeply Nested Array
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/flatten-deeply-nested-array/
// Runtime  : 34 ms (beats 0%)
// Memory   : 53400000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const res = [];
    
    function helper(currentArr, currentDepth) {
        for (const item of currentArr) {
            if (Array.isArray(item) && currentDepth < n) {
                helper(item, currentDepth + 1);
            } else {
                res.push(item);
            }
        }
    }
    
    helper(arr, 0);
    return res;
};
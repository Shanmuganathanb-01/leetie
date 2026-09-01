// ──────────────────────────────────────────────────
// Problem  : 2625. Flatten Deeply Nested Array
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/flatten-deeply-nested-array/
// Runtime  : 92 ms (beats 59%)
// Memory   : 74324000 (beats 78%)
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
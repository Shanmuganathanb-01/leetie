// ──────────────────────────────────────────────────
// Problem  : 2677. Chunk Array
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/chunk-array/
// Runtime  : 39 ms (beats 0%)
// Memory   : 53632000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const res = [];
    for (let i = 0; i < arr.length; i += size) {
        res.push(arr.slice(i, i + size));
    }
    return res;
};
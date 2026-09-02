// ──────────────────────────────────────────────────
// Problem  : 2677. Chunk Array
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/chunk-array/
// Runtime  : 48 ms (beats 50%)
// Memory   : 55688000 (beats 81%)
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
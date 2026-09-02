// ──────────────────────────────────────────────────
// Problem  : 2724. Sort By
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/sort-by/
// Runtime  : 102 ms (beats 87%)
// Memory   : 72928000 (beats 5%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    return arr.sort((a, b) => fn(a) - fn(b));
};
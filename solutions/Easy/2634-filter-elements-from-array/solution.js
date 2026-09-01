// ──────────────────────────────────────────────────
// Problem  : 2634. Filter Elements from Array
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/filter-elements-from-array/
// Runtime  : 43 ms (beats 59%)
// Memory   : 53696000 (beats 48%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const res = [];
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) {
            res.push(arr[i]);
        }
    }
    return res;
};
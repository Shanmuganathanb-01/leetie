// ──────────────────────────────────────────────────
// Problem  : 2635. Apply Transform Over Each Element in Array
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/apply-transform-over-each-element-in-array/
// Runtime  : 31 ms (beats 97%)
// Memory   : 52896000 (beats 87%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const res = new Array(arr.length);
    for (let i = 0; i < arr.length; i++) {
        res[i] = fn(arr[i], i);
    }
    return res;
};
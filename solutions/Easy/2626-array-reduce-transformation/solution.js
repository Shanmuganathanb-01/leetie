// ──────────────────────────────────────────────────
// Problem  : 2626. Array Reduce Transformation
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/array-reduce-transformation/
// Runtime  : 45 ms (beats 58%)
// Memory   : 53788000 (beats 73%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let val = init;
    for (let i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]);
    }
    return val;
};